package by.realovka.controller;

import by.realovka.dto.TelephoneDTO;
import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/userPage")
public class AccountController {

    @GetMapping(path = "/userPage")
    public ModelAndView getUserPage(ModelAndView modelAndView, HttpSession session){
      User auth = (User) session.getAttribute("userAuth");
      modelAndView.addObject("userAuth", auth);
      modelAndView.setViewName("account");
      return modelAndView;
    }
}
