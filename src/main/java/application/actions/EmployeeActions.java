package application.actions;


import application.dao.EmployeeDAO;
import application.entity.Employees;

public class EmployeeActions extends Employees {


    public void addEmployee(Employees emp){
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.createEmployee(emp);
    }

    public void removeEmployee(int empId){
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.deleteEmployee(empId);
    }

    public void postWorkPlace(){

    }
}
