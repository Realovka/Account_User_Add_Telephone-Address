package by.realovka.controller.address;

import by.realovka.dto.AddressUpdateDTO;
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
@RequestMapping(path = "/updateAddress")
public class AddressUpdateController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @GetMapping(path = "/updateAddress/{id}")
    public ModelAndView getUpdateAddress(@PathVariable long id, HttpSession httpSession,ModelAndView modelAndView){
        httpSession.setAttribute("idAddress", id);
        modelAndView.addObject("updateAddress",new AddressUpdateDTO());
        modelAndView.setViewName("updateAddress");
        return modelAndView;
    }

}
