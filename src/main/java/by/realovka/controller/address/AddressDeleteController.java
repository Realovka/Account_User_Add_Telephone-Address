package by.realovka.controller.address;

import by.realovka.dto.AddressDTO;
import by.realovka.entity.User;
import by.realovka.service.AddressService;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/deleteAddress")
public class AddressDeleteController {
    @Autowired
    private AddressService service;
    @Autowired
    private UserService userService;

    @GetMapping(path = "/deleteAddress/{id}")
    public ModelAndView getDeleteAddress(@PathVariable long id, ModelAndView modelAndView, HttpSession httpSession){
        service.deleteAddress(id);
        User auth = (User) httpSession.getAttribute("userAuth");
        User userAndHisAddresses = userService.getAuthUser(auth);
        modelAndView.addObject(" userAndHisAddresses", userAndHisAddresses);
        modelAndView.addObject("address", new AddressDTO());
        modelAndView.setViewName("address");
        return modelAndView;
    }
}
