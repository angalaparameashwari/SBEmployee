package application.controller;


import application.actions.Engineering;
import application.actions.Marketing;
import application.bean.Admin;
import application.bean.Sample;
import application.dao.AdminDAO;
import application.dao.EmployeeDAO;
import application.bean.Employees;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
//@SessionAttributes("userName")
@ComponentScan("com.howtodoinjava.web")
public class LoginController {
    private AdminDAO adminDAO = new AdminDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employees employees = new Employees();
    private Sample sample = new Sample();
    private Engineering engineering;
    private Marketing marketing;


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
    public String addUser(Employees employees) {
        return "adduser";
    }

//        @GetMapping("/adduser")
//    public String addUser(Sample sample) {
//        return "adduser";
//    }

    @PostMapping("/login")
    public String processForm(Admin admin, Employees employees) {
        System.out.println(admin.getPassWord());
        Boolean isAdmin =  adminDAO.verifyAdmin(admin);
        if(isAdmin){
            System.out.println("Welcome");
            return "menu";
        }
        else {
            System.out.println("--------------- :(");
            return "error"; //Validate user
        }
    }

//    @GetMapping("/employee")
//    public String addEmployeePage() {
//        return "employee";
//    }

    @PostMapping("/adduser")
    public String addEmployeeDetails(Employees employees) throws MessagingException, GeneralSecurityException, javax.mail.MessagingException, IOException {
        System.out.println(employees.getFirstname());
        int isEmployeeAdded =  employeeDAO.createEmployee(employees);
        if(isEmployeeAdded>0){
            System.out.println("Employee Added");
            greetEmployees(employees);
            engineering.greeting("angalaparameashwariap@gmail.com");
        }
        else {
            System.out.println("--------------- :( not added");
        }
        return "index";
    }


    private void greetEmployees(Employees employees) throws MessagingException, GeneralSecurityException, javax.mail.MessagingException, IOException {
        if(employees.getDept().toLowerCase().contains("engg"))
        {
            engineering = new Engineering();
            engineering.greeting(employees.getEmail());
            if(employees.getDesignation().toLowerCase().contains("dev") || employees.getDesignation().toLowerCase().contains("SDET"))
                engineering.repoAccess(employees.getEmail(),employees.getDesignation(),"Write");
            else
                engineering.repoAccess(employees.getEmail(),employees.getDesignation(),"readonly");
        }
        else if(employees.getDept().toLowerCase().contains("marketing")){
            marketing = new Marketing();
            marketing.greeting(employees.getEmail());
        }
    }
}