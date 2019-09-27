package application.dao;


import application.bean.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class AdminDAO {
    public int createAdmin(Admin admin) {
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
            PreparedStatement ps = con.prepareStatement("INSERT INTO admin VALUES (?,?)");
            ps.setString(1, admin.getUserName());
            ps.setString(2, admin.getPassWord());
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public int deleteAdmin(int username){
        int i = 0;
        try {
            DBConnection connection = new DBConnection();
            Connection con = connection.createConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE username = '${username}';");
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public Boolean verifyAdmin(Admin admin){
//     Admins admin = new Admins();
//     admin.setUserName("jk");
//     admin.setPassWord("jk");
        ResultSet i = null;
        try {
            DBConnection connection = new DBConnection();
            Connection con = connection.createConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?;");
            ps.setString(1,admin.getUserName());
            ps.setString(2,admin.getPassWord());
            i = ps.executeQuery();
            if(!i.next()) {
                System.out.println("Not found");
                return false;
            }
            else {
                System.out.println("found");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
