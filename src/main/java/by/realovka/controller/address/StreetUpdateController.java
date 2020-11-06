package by.realovka.controller.address;

import by.realovka.dto.AddressDTO;
import by.realovka.dto.StreetUpdateDTO;
import by.realovka.entity.User;
import by.realovka.service.AddressService;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/updateStreet")
public class StreetUpdateController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @GetMapping(path = "/updateStreet/{id}")
    public ModelAndView getUpdateStreet(@PathVariable long id, ModelAndView modelAndView) {
        modelAndView.addObject("street", new StreetUpdateDTO());
        modelAndView.setViewName("updateStreet");
        return modelAndView;
    }

    @PostMapping(path = "/updateStreet/{id}")
    public ModelAndView postUpdateStreet(@ModelAttribute("street") StreetUpdateDTO streetUpdateDTO, @PathVariable long id, BindingResult bindingResult,
                                         HttpSession httpSession, ModelAndView modelAndView) {
        if (!bindingResult.hasErrors()) {
            long idAddress = (long) httpSession.getAttribute("idAddress");
            addressService.updateStreet(idAddress, streetUpdateDTO);
            modelAndView.addObject("address", new AddressDTO());
            User userAuth = (User) httpSession.getAttribute("userAuth");
            User userAndHisAddresses = userService.getAuthUser(userAuth);
            modelAndView.addObject("userAndHisAddresses", userAndHisAddresses);
            modelAndView.addObject("address", new AddressDTO());
            modelAndView.setViewName("address");
        }
        return modelAndView;
    }
}
