package by.realovka.controller;

import by.realovka.dto.AddressDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/addAddress")
public class AddressAdditionController {

    @GetMapping(path = "/addAddress")
    public ModelAndView addAddress(ModelAndView modelAndView){
        modelAndView.addObject("address", new AddressDTO());
        modelAndView.setViewName("address");
        return modelAndView;
    }
}
