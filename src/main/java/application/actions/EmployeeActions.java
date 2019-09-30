package application.actions;


import application.bean.Admin;
import application.bean.Sample;
import application.dao.AdminDAO;
import application.dao.EmployeeDAO;
import application.bean.Employees;

public class EmployeeActions extends Employees {

    public void addEmployee(Employees emp){
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.createEmployee(emp);
    }

    public void removeEmployee(int empId){
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.deleteEmployee(empId);
    }


    public boolean validateUser(Employees employees){
        EmployeeDAO empDAO = new EmployeeDAO();
        boolean isValidUser = empDAO.aValidUser(employees);
        return isValidUser;
    }

    public boolean isAdminUser(Admin admin){
        AdminDAO adminDAO = new AdminDAO();
        boolean isAdminUser = adminDAO.verifyAdmin(admin);
        return isAdminUser;
    }

    public void postWorkPlace(){

    }
}
