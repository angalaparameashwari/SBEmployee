package application.services;

import application.bean.Employee;
import application.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public long count(){
        return employeeRepo.count();
    }

    public void addEmp(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }

    public void updateEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void getEmployee(int id){
        employeeRepo.getOne(id);
    }



}
