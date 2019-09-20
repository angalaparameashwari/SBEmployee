package application.actions;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marketing extends DepartmentActions {

    private String name;
    private String head;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getHead() {
        return head;
    }

    @Override
    public void setHead(String head) {
        this.head = head;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    private String module;

    public void greeting(String toGmail) throws MessagingException, IOException, javax.mail.MessagingException, GeneralSecurityException {
        super.greeting(toGmail);
        CustomerFacingTeam.greeting(toGmail);
    }


    public void typeCustomer(){
        CustomerFacingTeam customerFacingTeam =  (List<String> list) -> {
            //To do
        };
        List<String> list = new ArrayList<>(
                Arrays.asList("level1","Level2","Level3")
        );
       customerFacingTeam.typeCustomer(list);
    }
}
