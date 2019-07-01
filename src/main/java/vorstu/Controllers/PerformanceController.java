package vorstu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vorstu.Service.*;
import vorstu.model.Efficiency.Efficiency;
import vorstu.model.Efficiency.parts.EducationActivity;
import vorstu.model.Efficiency.parts.InternationalActivity;
import vorstu.model.Efficiency.parts.ResearchActivity;
import vorstu.model.Report.Department;
import vorstu.model.Report.Faculty;
import vorstu.model.Report.Report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PerformanceController {


    @Autowired
    private CalculateService calculateService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private EfficiencyService efficiencyService;

    @Autowired
    private ReportService reportService;


    /**
     * Загрузка страницы с просмотром статистики
     *
     * @return страница со статистикой
     */
    @GetMapping("/performance")
    public String loadPerformance(Model model) {
        List<Faculty> faculties = facultyService.findAll();
        model.addAttribute("faculties", faculties);
        return "performance";
    }


    @GetMapping("/input")
    public String loadCalculatePage(Model model) {
        List<Date> dates = new ArrayList<>();
        model.addAttribute("directions", departmentService.findAll());
        return "input";
    }

    @PostMapping("/input")
    public String getInputPage(@RequestParam Map<String, String> form) {
        calculateService.calculateEfficiency(form);
        return "redirect:/performance";
    }


    @GetMapping("performance/{faculty}")
    public String getPerformancePage(@PathVariable Faculty faculty, Model model) {
        List<Report> departmentReports = reportService.findAllByFaculty(faculty);
        Efficiency facultyEfficiency = efficiencyService.getAverageEfficiency(departmentReports);
        List<Department> departments = departmentService.findAllByFaculty(faculty);

        if (departmentReports.size() == 0){
            model.addAttribute("noData",true);
        }else {
            model.addAttribute("facultyEfficiency", facultyEfficiency);
            model.addAttribute("faculty", faculty);
            model.addAttribute("departments", departments);
        }
        return "facultyPerformance";
    }
}
