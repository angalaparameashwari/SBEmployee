package application.controller;


import application.bean.Admin;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getloginpage(Admin admin) {

        return "login.html";
    }

    @PostMapping("/login")
    public String processForm(Admin admin) {

        return "details.html";
    }

}