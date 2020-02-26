package application.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee{
        @Autowired
        private String firstname;
        @Column(name = "lastname")
        private String lastName;
        @Id
        private int id;
        @Column(name="department")
        private String dept;
        private Date DOB;
        private String email;
        private String designation;
        private String address;
        @Column(name="bloodgroup")
        private String bloodGrp;
        private String gender;
        @Column(name="phonenumber")
        private long phoneNumber;
        @Column(name="emergencycontact")
        private long emergencyContact;

        public String getFirstname() { return firstname; }
        public void setFirstname(String firstname) { this.firstname = firstname; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getDept() { return dept; }
        public void setDept(String dept) { this.dept = dept; }
        public Date getDOB() { return DOB; }
        public void setDOB(Date DOB) { this.DOB = DOB; }
        public String getDesignation() {
                return designation;
        }
        public void setDesignation(String designation) {
                this.designation = designation;
        }
        public String getAddress() {
                return address;
        }
        public void setAddress(String address) {
                this.address = address;
        }
        public void setEmail(String email){ this.email = email; }
        public String getEmail(){ return email; }
        public void setBloodGrp(String email){ this.bloodGrp = bloodGrp; }
        public String getBloodGrp(){ return bloodGrp; }
        public void setGender(String gender){ this.gender = gender; }
        public String getGender(){ return gender; }
        public void setPhoneNumber(long phoneNumber){ this.phoneNumber = phoneNumber; }
        public long getPhoneNumber(){ return phoneNumber; }
        public void setEmergencyContact(long emergencyContact){ this.emergencyContact = emergencyContact; }
        public long getEmergencyContact(){ return emergencyContact; }
}
