package application.dao;


import application.entity.Employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDAO {
    // public static void main(String arg[]){
    public int createEmployee(Employees employee) {
        // Employees employee = new Employees();
        int i = 0;
        try {
//            employee.setId(242);
//            employee.setFirstname("AP");
//            employee.setLastName("K");
//            employee.setEmail("angalaparameashwari@gmail.com");
//            employee.setGender("Female");
//            employee.setDesignation("SDET");
//            employee.setDept("Engineering");
//            employee.setPhoneNumber(8526933L);
//            employee.setEmergencyContact(979063L);
//            employee.setBloodGrp("A1B + ve");
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
              DBConnection connection = new DBConnection();
              Connection con = connection.createConnection();
            PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstname());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getGender());
            ps.setString(6, employee.getDesignation());
            ps.setString(7, employee.getDept());
            ps.setLong(8, employee.getPhoneNumber());
            ps.setLong(9, employee.getEmergencyContact());
            ps.setString(10, employee.getBloodGrp());

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public int deleteEmployee(int empId){
        int i = 0;
        try {
            DBConnection connection = new DBConnection();
            Connection con = connection.createConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id = '${empId}';");
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
