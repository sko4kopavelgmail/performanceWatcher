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

import java.util.*;
import java.util.stream.Collectors;

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
        List<Efficiency> efficiencies = new ArrayList<>();
        List<Report> departmentReports = new ArrayList<>();
        for (Faculty faculty : facultyService.findAll()) {
            departmentReports.addAll(reportService.findAllByFaculty(faculty));
            if (departmentReports.size() != 0)
                efficiencies.add(efficiencyService.getAverageEfficiency(departmentReports));
        }
        if (efficiencies.size() == 0) {
            model.addAttribute("noData", true);
        } else {
            model.addAttribute("uni", efficiencyService.getUniEfficiency(efficiencies));
        }
        return "performance";
    }

    @GetMapping("/faculties")
    public String loadFaculties(Model model) {
        List<Report> departmentReports = new ArrayList<>();
        Map<Double, Faculty> map = new LinkedHashMap<>();

        for (Faculty faculty : facultyService.findAll()) {
            departmentReports.addAll(reportService.findAllByFaculty(faculty));
            Efficiency efficiency = efficiencyService.getAverageEfficiency(departmentReports);
            Double d = efficiencyService.getFacultyScope(efficiency);
            map.put(d, faculty);
            departmentReports.clear();
        }

        Map<Double, Faculty> treeMap = new TreeMap<>(map);

        List<Faculty> faculties = new ArrayList<>(treeMap.values());

        model.addAttribute("faculties", faculties);
        return "faculties";
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

        if (departmentReports.size() == 0) {
            model.addAttribute("noData", true);
        } else {
            model.addAttribute("facultyEfficiency", facultyEfficiency);
            model.addAttribute("faculty", faculty);
            model.addAttribute("departments", departments);
        }
        return "facultyPerformance";
    }
}
