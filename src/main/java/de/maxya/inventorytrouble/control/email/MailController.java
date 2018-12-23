package de.maxya.inventorytrouble.control.email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class MailController {
	public void sendOhneAnhang(String toEmail, String subject, String text) {
		sendMitAnhang(toEmail, subject, text, null);
	}

	public void sendMitAnhang(String toEmail, String subject, String text, MimeBodyPart anhang) {
		List<MimeBodyPart> anhaenge = new ArrayList<MimeBodyPart>();
		if (anhang != null)
			anhaenge.add(anhang);
		sendMitAnhaengen(toEmail, subject, text, anhaenge);
	}

	public void sendMitAnhaengen(String toEmail, String subject, String text, List<MimeBodyPart> anhang) {
		// Recipient's email ID needs to be mentioned.
		String to = toEmail;
		String cc = "lutzfinke2010@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "inventory@maxya.de";

		// Assuming you are sending email from localhost
		String host = "smtp.1und1.de";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		SmtpAuthenticator authentication = new SmtpAuthenticator();

		// Get the default Session object.
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties, authentication);
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));

			// Set Subject: header field
			message.setSubject(subject);

			message.setContent(text, "text/html");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			System.out.println("Error" + mex);
		}
	}
}
