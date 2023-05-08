/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import java.util.Properties;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 *
 * @author maheshsai
 */
public class MailService {
    private class SMTPAuthenticator extends javax.mail.Authenticator {

    public PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication("maheshsai252@gmail.com", "<password>");
    }
  }
    public void actionPerformed(String subject, String text, String from, String to) {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.user", "maheshsai252@gmail.com");

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.socketFactory.fallback", "false");

//            Session session = Session.getDefaultInstance(props);
            SecurityManager security = System.getSecurityManager();
            
            try {
                Authenticator auth = new SMTPAuthenticator();
                Session session = Session.getInstance(props, auth);
      // session.setDebug(true);

      MimeMessage msg = new MimeMessage(session);
      msg.setText(text);
      msg.setSubject(subject);
      msg.setFrom(new InternetAddress("maheshsai252@gmail.com"));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      Transport.send(msg);
                
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
}
