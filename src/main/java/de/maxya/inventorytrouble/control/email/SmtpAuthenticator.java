package de.maxya.inventorytrouble.control.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
		public SmtpAuthenticator() {

		    super();
		}

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
		 String username = "inventory@maxya.de";
		 String password = "billy5mareen";
		    if ((username != null) && (username.length() > 0) && (password != null) 
		      && (password.length   () > 0)) {

		        return new PasswordAuthentication(username, password);
		    }

		    return null;
		}
	}
