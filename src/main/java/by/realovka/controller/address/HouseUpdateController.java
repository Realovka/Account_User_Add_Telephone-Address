package by.realovka.controller.address;

import by.realovka.dto.AddressDTO;
import by.realovka.dto.HouseUpdateDTO;
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
@RequestMapping(path = "/updateHouse")
public class HouseUpdateController {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @GetMapping(path = "/updateHouse/{id}")
    public ModelAndView getUpdateHouse(@PathVariable long id, ModelAndView modelAndView){
        modelAndView.addObject("house", new HouseUpdateDTO());
        modelAndView.setViewName("updateHouse");
        return modelAndView;
    }

    @PostMapping(path = "/updateHouse/{id}")
    public ModelAndView postUpdateHouse(@ModelAttribute("house")HouseUpdateDTO houseUpdateDTO, @PathVariable long id, BindingResult bindingResult,
                                        HttpSession httpSession, ModelAndView modelAndView){
        if (!bindingResult.hasErrors()) {
            long idAddress = (long) httpSession.getAttribute("idAddress");
            addressService.updateHouse(idAddress, houseUpdateDTO);
            modelAndView.addObject("house", new HouseUpdateDTO());
            User userAuth = (User) httpSession.getAttribute("userAuth");
            User userAndHisAddresses = userService.getAuthUser(userAuth);
            modelAndView.addObject("userAndHisAddresses", userAndHisAddresses);
            modelAndView.addObject("address", new AddressDTO());
            modelAndView.setViewName("address");
        }
        return  modelAndView;
    }
}
