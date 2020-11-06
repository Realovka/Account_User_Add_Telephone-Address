package by.realovka.controller.telephone;

import by.realovka.dto.TelephoneDTO;
import by.realovka.entity.User;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/addTelephone")
public class TelephoneAdditionController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/addTelephone")
    public ModelAndView getAddTelephone(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.addObject("telephone", new TelephoneDTO());
        User auth = (User) httpSession.getAttribute("userAuth");
        User userAndHisTelephones = userService.getAuthUser(auth);
        modelAndView.addObject("userAndHisTelephones",userAndHisTelephones);
        modelAndView.setViewName("telephone");
        return modelAndView;
    }

    @PostMapping(path = "/addTelephone")
    public ModelAndView postAddTelephone(@Valid @ModelAttribute("telephone") TelephoneDTO telephoneDTO, BindingResult bindingResult, HttpSession httpSession,
                                         ModelAndView modelAndView) {
        if (!bindingResult.hasErrors()) {
            User auth = (User) httpSession.getAttribute("userAuth");
            userService.updateUserAddTelephone(auth, telephoneDTO, httpSession);
            modelAndView.addObject("telephone", new TelephoneDTO());
            User userAndHisTelephones = userService.getAuthUser(auth);
            modelAndView.addObject("userAndHisTelephones",userAndHisTelephones);
        }
        modelAndView.setViewName("telephone");
        return modelAndView;
    }
}