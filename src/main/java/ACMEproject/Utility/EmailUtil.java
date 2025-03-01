package ACMEproject.Utility;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String subject, String body) {
        final String username = "winsoftdemo@winsoftech.in"; // Your email
        final String password = "Winsoft@12345"; // Your email password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.hostinger.com"); // Your SMTP host
        props.put("mail.smtp.port", "587"); // SMTP port

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("chinmayk@winsoftech.com"));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email Sent Successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

