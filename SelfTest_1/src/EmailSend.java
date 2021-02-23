import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class EmailSend {

    public static void main(String args[]){
        try{
            String host ="smtp.gmail.com" ;
            String user = "dbabot.testmailer@gmail.com";
            String pass = "dba@botmail";
            String to = "saket1907@hotmail.com";
            String from = "dbabot.testmailer@gmail.com";
            String subject = "Mail for approval of server bounce";
            String messageText = "Your Is Test Email :";
            String sb = "<p><span>Hi Approver,</span></p>"
            		+"<p>&nbsp;</p>"
            		+"<p><span>This mail is regarding the bounce of the dev/test server.</span></p>"
            		+"<p><span>The mentioned server (<span><strong>HostnameOfServer</strong></span>) needs to be bounced.</span></p>"
            		+"<p>&nbsp;</p>"
            		+"<p><span>Please provide your approval for the bounce.</span></p>"
            		+"<p>&nbsp;</p>"
            		+"<p><span>Regards.</span></p>"
            		+"<p><span>Sender</span></p>";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            
            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);   //Mime added in message
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
			msg.setContent(sb, "text/html");                                   
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}
