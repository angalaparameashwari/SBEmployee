package application.controller;


import application.bean.Admin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@SessionAttributes("userName")
@ComponentScan("com.howtodoinjava.web")
public class LoginController {

    @GetMapping("/login")
    public String getloginpage(Admin admin) {

        return "login";
    }

    @PostMapping("/login")
    public String processForm(Admin admin) {
        return "details";
    }

}