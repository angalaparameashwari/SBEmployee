package application.controller;


import application.bean.Admin;
import application.bean.Sample;
import application.dao.AdminDAO;
import application.dao.EmployeeDAO;
import application.bean.Employees;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@SessionAttributes("userName")
@ComponentScan("com.howtodoinjava.web")
public class LoginController {
    private AdminDAO adminDAO = new AdminDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employees employees = new Employees();
    private Sample sample = new Sample();


    @GetMapping("/login")
    public String getloginpage(Admin admin) {
        return "login";
    }

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
        }
        else {
            System.out.println("--------------- :(");
        }
        return "adduser";
    }

//    @GetMapping("/employee")
//    public String addEmployeePage() {
//        return "employee";
//    }

    @PostMapping("/adduser")
    public String addEmployeeDetails(Employees employees) {
        System.out.println(employees.getFirstname());
        int isEmployeeAdded =  employeeDAO.createEmployee(employees);
        if(isEmployeeAdded>0){
            System.out.println("Employee Added");
        }
        else {
            System.out.println("--------------- :( not added");
        }
        return "index";
    }
}