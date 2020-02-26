package application.repo;

import application.bean.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {
     // boolean deleteAdminByUserName(String userName);
//      List<Admin> getAdminByPassWord();
//      List<Admin> getAdminByUserName();
        List<Admin> findAllByPassWord(String password);
    @Query(value = "SELECT * FROM admin WHERE username = ?1 AND password = ?2", nativeQuery = true)
    Admin findAdminByUserNameAndPassWord(String username, String password);

}
