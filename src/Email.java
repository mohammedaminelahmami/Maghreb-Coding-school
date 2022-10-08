import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    public static boolean sendEmail(String email){
        final String user="lahmamimohammedamine@gmail.com";
        final String password="************";

        // get the session object
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        // compose of the mail
        // try catch to handle errors
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject("New Brief !");
            message.setText("New Brief has been Created !");

            // try to send mail
            Transport.send(message);
            System.out.println("brief sent to learner successfully :)");
        }catch (MessagingException e){
            // System.out.println("something went wrong "+ e.getMessage());
            return false;
        }
        return true;
    }
}