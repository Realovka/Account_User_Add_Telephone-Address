package by.realovka.controller.address;

import by.realovka.dto.AddressDTO;
import by.realovka.dto.FlatUpdateDTO;
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
@RequestMapping(path = "/updateFlat")
public class FlatUpdateController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @GetMapping(path = "/updateFlat/{id}")
    public ModelAndView getUpdateFlat(@PathVariable long id, ModelAndView modelAndView){
        modelAndView.addObject("flat", new FlatUpdateDTO());
        modelAndView.setViewName("updateFlat");
        return modelAndView;
    }

    @PostMapping(path = "/updateFlat/{id}")
    public ModelAndView postUpdateHouse(@ModelAttribute("flat")FlatUpdateDTO flatUpdateDTO, @PathVariable long id, BindingResult bindingResult,
                                        HttpSession httpSession, ModelAndView modelAndView){
        if (!bindingResult.hasErrors()) {
            long idAddress = (long) httpSession.getAttribute("idAddress");
            addressService.updateFlat(idAddress, flatUpdateDTO);
            modelAndView.addObject("flat", new FlatUpdateDTO());
            User userAuth = (User) httpSession.getAttribute("userAuth");
            User userAndHisAddresses = userService.getAuthUser(userAuth);
            modelAndView.addObject("userAndHisAddresses", userAndHisAddresses);
            modelAndView.addObject("address", new AddressDTO());
            modelAndView.setViewName("address");
        }
        return  modelAndView;
    }
}
