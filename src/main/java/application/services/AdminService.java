package application.services;

import application.bean.Admin;
import application.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public long count(){
        return adminRepo.count();
    }

    public void addAdmin(Admin admin){
        adminRepo.save(admin);
    }

    public void deleteAdmin(String userName){
        adminRepo.deleteById(userName);
    }

    public boolean verifyAdmin(Admin admin){
        Optional<Admin> optionalAdmin =  adminRepo.findById(admin.getUserName());
        Admin admin1 = optionalAdmin.orElseGet(() -> {
            return new Admin();
        });
        if(!(admin.equals(admin1)) || admin1.equals(null))
            return false;
        else
            return true;

    }

}
