package by.realovka.controller.telephone;

import by.realovka.dto.TelephoneDTO;
import by.realovka.dto.TelephoneUpdateDTO;
import by.realovka.entity.User;
import by.realovka.service.TelephoneService;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/updateTelephone")
public class TelephoneUpdateController {
    @Autowired
    private TelephoneService telephoneService;
    @Autowired
    private UserService userService;

    @GetMapping(path = "/updateTelephone/{id}")
    public ModelAndView getUpdateTelephone(@PathVariable long id,HttpSession httpSession, ModelAndView modelAndView){
        httpSession.setAttribute("id",id);
        modelAndView.addObject("updateTelephone", new TelephoneUpdateDTO());
        modelAndView.setViewName("updateTelephone");
        return modelAndView;
    }

    @PostMapping(path = "/updateTelephone/{id}")
    public ModelAndView postUpdateTelephone(@Valid@ModelAttribute("updateTelephone") TelephoneUpdateDTO telephoneUpdateDTO,@PathVariable long id, BindingResult bindingResult, HttpSession httpSession,
                                            ModelAndView modelAndView){
       if(!bindingResult.hasErrors()){
           long idTelephone =(long) httpSession.getAttribute("id");
           User auth = (User) httpSession.getAttribute("userAuth");
           telephoneService.updateTelephone(idTelephone,telephoneUpdateDTO);
           User userAndHisTelephones = userService.getAuthUser(auth);
           modelAndView.addObject("userAndHisTelephones",userAndHisTelephones);
           modelAndView.addObject("telephone", new TelephoneDTO());
           modelAndView.setViewName("telephone");
       }
        return modelAndView;
    }

}
