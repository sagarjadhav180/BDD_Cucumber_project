package utils;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.io.File;
public class EmailUtil {

    public static void sendReportEmail(String toEmail, String reportPath) {
        final String fromEmail = "sagar.jadhav2343@gmail.com"; // your email
        final String password = "lten tatl vwum aceb";           // your email password or app password
        final String subject = "Automation Test Report";
        final String body = "Please find the attached Extent Report for the latest execution.";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Or your SMTP server
        props.put("mail.smtp.port", "587");            // Port for TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        session.setDebug(true);  // 🔍 This will print all SMTP details in console
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            // Email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(reportPath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("✅ Email Sent with report attached.");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Email sending failed.");
        }
    }
}
