package by.realovka.controller.address;

import by.realovka.dto.AddressDTO;
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
@RequestMapping(path = "/addAddress")
public class AddressAdditionController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/addAddress")
    public ModelAndView getAddAddress(ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.addObject("address", new AddressDTO());
        User authUser = (User) httpSession.getAttribute("userAuth");
        User userAndHisAddresses = userService.getAuthUser(authUser);
        modelAndView.addObject("userAndHisAddresses", userAndHisAddresses);
        modelAndView.setViewName("address");
        return modelAndView;
    }

    @PostMapping(path = "/addAddress")
    public ModelAndView postAddAddress(@Valid @ModelAttribute("address") AddressDTO addressDTO, BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
        if (!bindingResult.hasErrors()){
            User authUser = (User) httpSession.getAttribute("userAuth");
            userService.updateUserAddAddress(authUser,addressDTO,httpSession);
            modelAndView.addObject("address",new AddressDTO());
            User userAndHisAddresses = userService.getAuthUser(authUser);
            modelAndView.addObject("userAndHisAddresses",userAndHisAddresses);
        }
        modelAndView.setViewName("address");
        return modelAndView;
    }
}
