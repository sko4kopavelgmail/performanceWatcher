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


    /**
     * Загрузка страницы с выбором подсчитываемой статистики
     * @return страница
     */
    @GetMapping("/calculatePerformance")
    public String loadCalculatePage(Model model){
        return "calculatePerformance";
    }

    /**
     * Получение данных со страницы с выбором подсчитываемой статистики
     * @param form форма
     * @return переход на страницу с вводом данных
     */
    @PostMapping("/calculatePerformance")
    public String getCalculatePage(@RequestParam Map<String,String> form){
        return "performance";
    }


    @GetMapping("/input")
    public String loadInputPage(){
        return "input";
    }

    @PostMapping("/input")
    public String getInputPage(@RequestParam Map<String, String> f){

        return "redirect:/calculatePerformance";
    }

}
