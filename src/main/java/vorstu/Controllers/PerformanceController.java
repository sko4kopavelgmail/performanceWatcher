package vorstu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vorstu.Service.CalculateService;
import vorstu.repo.Report.DepartmentRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PerformanceController {


    @Autowired
    private CalculateService calculateService;

    @Autowired
    private DepartmentRepo departmentRepo;


    /**
     * Загрузка страницы с просмотром статистики
     * @return страница со статистикой
     */
    @GetMapping("/performance")
    public String loadPerformance() {
        return "performance";
    }


    @GetMapping("/input")
    public String loadCalculatePage(Model model){
        List<Date> dates = new ArrayList<>();
        model.addAttribute("directions",departmentRepo.findAll());
        return "input";
    }

    @PostMapping("/input")
    public String getInputPage(@RequestParam Map<String, String> form){
        calculateService.calculateEfficiency(form);
        return "redirect:/performance";
    }

}
