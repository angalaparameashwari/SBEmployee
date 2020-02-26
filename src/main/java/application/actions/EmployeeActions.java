//package application.actions;
//
//
//import application.bean.Admin;
//import application.bean.Employee;
//import application.dao.AdminDAO;
//import application.dao.EmployeeDAO;
//
//public class EmployeeActions extends Employee {
//
//    public void addEmployee(Employee emp){
//        EmployeeDAO empDAO = new EmployeeDAO();
//        empDAO.createEmployee(emp);
//    }
//
//    public void removeEmployee(int empId){
//        EmployeeDAO empDAO = new EmployeeDAO();
//        empDAO.deleteEmployee(empId);
//    }
//
//
//    public boolean validateUser(Employee employee){
//        EmployeeDAO empDAO = new EmployeeDAO();
//        boolean isValidUser = empDAO.aValidUser(employee);
//        return isValidUser;
//    }
//
//    public boolean isAdminUser(Admin admin){
//        AdminDAO adminDAO = new AdminDAO();
//        boolean isAdminUser = adminDAO.verifyAdmin(admin);
//        return isAdminUser;
//    }
//
//    public void postWorkPlace(){
//
//    }
//}
