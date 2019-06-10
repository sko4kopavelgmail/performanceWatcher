package vorstu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vorstu.Service.CalculateService;

import java.util.Map;

@Controller
public class PerformanceController {


    @Autowired
    private CalculateService calculateService;

    /**
     * Загрузка страницы с просмотром статистики
     * @return страница со статистикой
     */
    @GetMapping("/performance")
    public String loadPerformance() {
        return "performance";
    }


    @GetMapping("/input")
    public String loadCalculatePage(){
        return "input";
    }

    @PostMapping("/input")
    public String getInputPage(@RequestParam Map<String, String> form){
        calculateService.calculateEfficiency(form);
        return "redirect:/performance";
    }

}
