package application.controller;


import application.bean.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getloginpage(Admin admin) {
        return "login.html";
    }

}