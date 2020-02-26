package application.controller;


import application.actions.Engineering;
import application.actions.Marketing;
import application.bean.Admin;
import application.bean.Employee;
import application.errorhandling.RecordNotFoundException;
import application.services.AdminService;
import application.services.EmployeeService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
//@SessionAttributes("userName")
@ComponentScan("com.howtodoinjava.web")
public class LoginController {
    private Engineering engineering;
    private Marketing marketing;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AdminService adminService;



    //Index page mapping
    @RequestMapping(value = {"/index","/"})
    public String landingpage() {
        return "index";
    }

    //Login page get mapping
    @GetMapping("/login")
    public String getloginpage(Admin admin) {
        return "login";
    }

    //Add user page get mapping
    @GetMapping("/adduser")
    public String addUser(Employee employee) {
        return "adduser";
    }

    //Delete user page get mapping
    @GetMapping("/deleteuser")
    public String deleteUser(Employee employee) {
        return "deleteuser";
    }


    @PostMapping("/login")
    public String processForm(Admin admin) {
        System.out.println(admin.getPassWord());
      //  Boolean isAdmin =  adminDAO.verifyAdmin(admin);
        boolean isAdmin = adminService.verifyAdmin(admin);
        if(isAdmin){
            System.out.println("Welcome");
            return "menu";
        }
        else {
            System.out.println("--------------- :(");
            throw new RecordNotFoundException("Admin not found");
        }
    }

    @PostMapping("/adduser")
    public String addEmp(Employee employee) throws MessagingException, GeneralSecurityException, javax.mail.MessagingException, IOException {
        employeeService.addEmp(employee);
        System.out.println("Employee Added");
        greetEmployees(employee);
        engineering.greeting(employee.getEmail());
        return "index";
    }

    @PostMapping("/deleteUser")
    public String deleteEmp(Employee employee) throws MessagingException, GeneralSecurityException, javax.mail.MessagingException, IOException {
        employeeService.deleteEmployee(employee.getId());
        System.out.println("Employee deleted");
        return "index";
    }


    private void greetEmployees(Employee employee) throws MessagingException, GeneralSecurityException, javax.mail.MessagingException, IOException {
        if(employee.getDept().toLowerCase().contains("engg"))
        {
            engineering = new Engineering();
            engineering.greeting(employee.getEmail());
            if(employee.getDesignation().toLowerCase().contains("dev") || employee.getDesignation().toLowerCase().contains("SDET"))
                engineering.repoAccess(employee.getEmail(), employee.getDesignation(),"Write");
            else
                engineering.repoAccess(employee.getEmail(), employee.getDesignation(),"readonly");
        }
        else if(employee.getDept().toLowerCase().contains("marketing")){
            marketing = new Marketing();
            marketing.greeting(employee.getEmail());
        }
    }
}