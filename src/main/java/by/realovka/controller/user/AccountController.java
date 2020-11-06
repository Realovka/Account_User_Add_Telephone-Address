package by.realovka.controller.user;

import by.realovka.entity.User;
import by.realovka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/userPage")
public class AccountController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/userPage")
    public ModelAndView getUserPage(ModelAndView modelAndView, HttpSession httpSession) {
        User auth = (User) httpSession.getAttribute("userAuth");
        User userAndHisTelephonesAndAddresses = userService.getAuthUser(auth);
        modelAndView.addObject("userAndHisTelephonesAndAddresses", userAndHisTelephonesAndAddresses);
        modelAndView.setViewName("account");
        return modelAndView;
    }
}
