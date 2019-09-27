package application.actions;


import application.bean.Sample;
import application.dao.EmployeeDAO;
import application.bean.Employees;

public class EmployeeActions extends Employees {

//................need to be changed............
//
//    public void addEmployee(Sample emp){
//        EmployeeDAO empDAO = new EmployeeDAO();
//        empDAO.createEmployee(emp);
//    }
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
