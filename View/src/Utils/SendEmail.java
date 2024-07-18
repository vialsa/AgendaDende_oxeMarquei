package Utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.activation.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void sender(String receiverEmail, String subject, String text) {
        String sender = "testesmtp58@gmail.com";
        String senderPassword = "ecue drfn kmup fypu";

        Properties properties = new Properties();
        properties.put("mail.smtp.user",sender);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        System.out.println("Enviando mensagem...");

        try {
            Authenticator auth = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sender, senderPassword);
                }
            };

            Session session = Session.getDefaultInstance(properties, auth);
            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(sender));
            msg.setText(text);
            msg.setSubject(subject);
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiverEmail));

            Transport.send(msg);
            System.out.println("Email enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
