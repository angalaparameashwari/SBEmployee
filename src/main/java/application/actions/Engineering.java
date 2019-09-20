package application.actions;

import application.utils.FileHandler;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Engineering extends DepartmentActions {

    private String name;
    private String head;

    private ArrayList<String> reposQA = new ArrayList<String>(
            Arrays.asList("cb-app","cb-core", "cb-qa")
            );
    private ArrayList<String> reposDev = new ArrayList<String>(
            Arrays.asList("cb-app","cb-core", "cb-fw")
    );


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

    ArrayList<String> categories = new ArrayList<>(
            Arrays.asList("Developement", "QA", "TechWriters"));
//    /**
//     * @param name Name of the department
//     * @param head Name of the department head.
//     * @param module Core module of the department (subs/invoice/gateway etc)
//     */
//
//    Engineering(String name,String head, String module){
//
//    }

    public void greeting(String toGmail) throws MessagingException, IOException, javax.mail.MessagingException, GeneralSecurityException {
        super.greeting(toGmail);
        String user = "me";
        File file = new File("/Users/cb-angalaparameashwari/Documents/AP/Employee/resources/samplemail");
        String mailContentpath = "/Users/cb-angalaparameashwari/Documents/AP/Employee/resources/EngineeringGreeting";
        GmailQuickstart gmailQuickstart = new GmailQuickstart();
        EmailActions emailActions = new EmailActions();
        emailActions.sendMessage(gmailQuickstart.getGmailService(),user,emailActions.createEmailWithAttachment(toGmail,"angalaparameashwari@gmail.com",
                "Welcome!!", FileHandler.readLineByLine(mailContentpath),file));
    }

    public void repoAccess(String forGmail,String catogory, String accessType) throws MessagingException, IOException, javax.mail.MessagingException, GeneralSecurityException {
       if(!(catogory.contains("Development") || catogory.contains("QA"))){
           return;
       }
        String user = "me";
        File file = new File("/Users/cb-angalaparameashwari/Documents/AP/Employee/resources/samplemail");
        String mailContentpath = "/Users/cb-angalaparameashwari/Documents/AP/Employee/resources/EngineeringGreeting";
        GmailQuickstart gmailQuickstart = new GmailQuickstart();
        EmailActions emailActions = new EmailActions();
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("teams.properties"));
        if(catogory.contains("Development"))
        emailActions.sendMessage(gmailQuickstart.getGmailService(),user,emailActions.createEmail(properties.getProperty("noc.mail"),"angalaparameashwari@gmail.com",
                "Repo access for " + forGmail, FileHandler.readLineByLineAppendString(mailContentpath,"the access type required is " + accessType + "\n" +reposDev )));

        else {
            emailActions.sendMessage(gmailQuickstart.getGmailService(),user,emailActions.createEmail(properties.getProperty("noc.mail"),"angalaparameashwari@gmail.com",
                    "Repo access for " + forGmail, FileHandler.readLineByLineAppendString(mailContentpath,"the access type required is " + accessType + "\n" +reposQA )));
        }
    }


}
