package by.realovka.controller.address;

import by.realovka.dto.AddressDTO;
import by.realovka.dto.CityUpdateDTO;
import by.realovka.entity.User;
import by.realovka.service.AddressService;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/updateCity")
public class CityUpdateController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;


    @GetMapping(path = "/updateCity/{id}")
    public ModelAndView getUpdateCity(@PathVariable long id, ModelAndView modelAndView){
        modelAndView.addObject("city", new CityUpdateDTO());
        modelAndView.setViewName("updateCity");
        return modelAndView;
    }

    @PostMapping(path = "/updateCity/{id}")
    public ModelAndView postUpdateCity(@Valid @ModelAttribute("city")CityUpdateDTO cityUpdateDTO, @PathVariable long id, BindingResult bindingResult,
                                       HttpSession httpSession, ModelAndView modelAndView){
        if(!bindingResult.hasErrors()){
            long idAddress = (long) httpSession.getAttribute("idAddress");
            addressService.updateCity(idAddress,cityUpdateDTO);
            modelAndView.addObject("address", new AddressDTO());
            User authUser = (User) httpSession.getAttribute("userAuth");
            User userAndHisAddresses = userService.getAuthUser(authUser);
            modelAndView.addObject("address", new AddressDTO());
            modelAndView.addObject("userAndHisAddresses", userAndHisAddresses);
            modelAndView.setViewName("address");
        }
        return modelAndView;
    }
}
