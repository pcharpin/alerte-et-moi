/**
 * 
 */
package com.objectif.informatique.alerte.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author gsoh
 *
 */
public class SmtpMailSender {
	
	
	
	
	private final static String MAILER_VERSION = "Java";

	private final static String alertepasswd = "";
	
	private String adressFrom;
	
	private String adressTo;

	private String server;
	
	private Session session;
	
	private boolean smtpAuthEnable;
	
	public SmtpMailSender(){};
	
	public SmtpMailSender(String server, String adressFrom, String adressTo, boolean smtpAuthEnable){
		
		this.adressFrom = adressFrom;
		this.adressTo = adressTo;
		this.server = server;
		this.smtpAuthEnable = smtpAuthEnable;		
	}

	public boolean sendMailSMTP(boolean debug, String txtmessage) {

		boolean result = false;
	
		try {
	
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", server);
			
			if ( isSmtpAuthEnable() )
			{
				getPasswd();
				prop.put("mail.smtp.auth", smtpAuthEnable);
				prop.put("mail.smtp.starttls.enable", "true");
				this.session = Session.getDefaultInstance(prop, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {  
					       return new PasswordAuthentication(adressFrom, alertepasswd);
					}
				});
			}
			else {
				
				this.session = Session.getDefaultInstance(prop, null);
			}
			
	
		
			Message message = new MimeMessage(this.session);
		
			message.setFrom(new InternetAddress(adressFrom));
		
			InternetAddress[] internetAddresses = new InternetAddress[1];
		
			internetAddresses[0] = new InternetAddress(adressTo);
		
			message.setRecipients(Message.RecipientType.TO,internetAddresses);
		
			message.setSubject("Alerte Event");
			message.setText(txtmessage);
		
			message.setHeader("X-Mailer", MAILER_VERSION);
		
			message.setSentDate(new Date());
		
			this.session.setDebug(debug);
			Transport.send(message);
		
			result = true;
	
		} catch (AddressException e) {
	
			e.printStackTrace();
	
		} catch (MessagingException e) {
	
			e.printStackTrace();
	
		}
	
		return result;
		
	}

	public String getAdressFrom() {
		return adressFrom;
	}

	public void setAdressFrom(String adressFrom) {
		this.adressFrom = adressFrom;
	}

	public String getAdressTo() {
		return adressTo;
	}

	public void setAdressTo(String adressTo) {
		this.adressTo = adressTo;
	}

	public String getPasswd() {
		return alertepasswd;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean isSmtpAuthEnable() {
		return smtpAuthEnable;
	}

	public void setSmtpAuthEnable(boolean smtpAuthEnable) {
		this.smtpAuthEnable = smtpAuthEnable;
	}

	public static String getMailerVersion() {
		return MAILER_VERSION;
	}

}
