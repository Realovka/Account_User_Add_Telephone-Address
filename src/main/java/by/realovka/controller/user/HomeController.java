package by.realovka.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @RequestMapping("/page")
    public ModelAndView getHomePage(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
