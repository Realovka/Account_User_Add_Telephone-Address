package by.realovka.controller;

import by.realovka.dto.UserAuthDTO;
import by.realovka.dto.UserRegDTO;
import by.realovka.entity.User;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/reg-auth")
public class RegistrationAndAuthorizationController {

    @Autowired
    private UserService userService;

//    public RegistrationAndAuthorizationController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping(path = "/reg")
    public ModelAndView getReg(ModelAndView modelAndView) {
        modelAndView.addObject("userReg", new UserRegDTO());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postReg(@Valid @ModelAttribute("userReg") UserRegDTO userRegDTO, BindingResult bindingResult, ModelAndView modelAndView) {
        if (!bindingResult.hasErrors()) {
            if (!userService.findByLogin(userRegDTO)) {
                userService.save(userRegDTO);
                modelAndView.setViewName("home");
            }
        }
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuth(ModelAndView modelAndView) {
        modelAndView.addObject("userAuth", new UserAuthDTO());
        modelAndView.setViewName("authorization");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView postAuth(@Valid @ModelAttribute("userAuth") UserAuthDTO userAuthDTO, BindingResult bindingResult, HttpSession httpSession, ModelAndView modelAndView) {
        if (!bindingResult.hasErrors()) {
            if (userService.findByLoginAndPassword(userAuthDTO)) {
                User userAuth = userService.findAuthUserByLogin(userAuthDTO);
                httpSession.setAttribute("ttt",userAuthDTO); //проверка авториз юзера
                httpSession.setAttribute("userAuth", userAuth);
                modelAndView.setViewName("account");
            }
        }
        return modelAndView;
    }

}
