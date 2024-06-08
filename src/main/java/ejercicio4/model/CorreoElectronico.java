package ejercicio4.model;

import jakarta.mail.*;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class CorreoElectronico extends Notificacion {
    private Properties props = new Properties();
    private String username;
    private String password;
    private String host;
    private String remitente;
    private String asunto;
    private String mensaje;

    public CorreoElectronico(String username, String password, String host,String remitente, String asunto, String mensaje) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.props.put("mail.smtp.auth", "true");
        this.props.put("mail.smtp.starttls.enable", "true");
        this.props.put("mail.smtp.host", host);
        this.props.put("mail.smtp.port", "587");
        this.remitente = remitente;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public void enviarNotificacion(String destinatario) {
        Session session = Session.getInstance(this.props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CorreoElectronico.this.username, CorreoElectronico.this.password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipient(RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
        } catch (MessagingException var7) {
            throw new RuntimeException(var7);
        }
    }
}
