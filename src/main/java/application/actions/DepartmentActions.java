package application.actions;

import application.utils.FileHandler;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;


import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DepartmentActions {
    private String name;
    private String head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
   // public static void main(String arg[])throws MessagingException, IOException, javax.mail.MessagingException, GeneralSecurityException {
   public void greeting(String toGmail) throws MessagingException, IOException, javax.mail.MessagingException, GeneralSecurityException {
        String user = "me";
       // String toGmail = "angalaparameashwariap@gmail.com";
        File file = new File("/Users/cb-angalaparameashwari/Documents/AP/Employee/resources/samplemail");
       String mailContentpath = "/Users/cb-angalaparameashwari/Documents/AP/Employee/resources/WelcomeGreeting";
        GmailQuickstart gmailQuickstart = new GmailQuickstart();
        EmailActions emailActions = new EmailActions();
        emailActions.sendMessage(gmailQuickstart.getGmailService(),user,emailActions.createEmailWithAttachment(toGmail,"angalaparameashwari@gmail.com",
                "Welcome!!", FileHandler.readLineByLine(mailContentpath),file));
    }
}
