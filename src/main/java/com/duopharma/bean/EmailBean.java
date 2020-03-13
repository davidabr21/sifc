package com.duopharma.bean;
 
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
@ManagedBean(name="email")
@ViewScoped
public class EmailBean {
	private final Properties properties = new Properties();
	
	private Session session;
	
	private String errorMessage;
	private String emails;
	private String mensaje;
	private String asunto;
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setEmails(List<String> emails) {
		this.emails = "";
		int size = emails.size();
		for(String e: emails) {
			if(emails.indexOf(e) + 1 == size) {
				this.emails = this.emails + e;
			} else {				
				this.emails = this.emails + e + ", ";
			}
			System.out.println(e);
		}
	}

	private void init() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.mail.sender","duopharmaco@gmail.com");
		properties.put("mail.smtp.user", "duopharmaco@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
 
	public void sendEmail(){
		System.out.println(this.emails);
		List<String> items = Arrays.asList(this.emails.trim().split("\\s*,\\s*"));
		for(String fromEmail: items) {
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(fromEmail));
			message.setSubject(this.asunto);
			message.setText(mensaje);
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "Caravela12345");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
			me.printStackTrace();
		}
		}
	}
}