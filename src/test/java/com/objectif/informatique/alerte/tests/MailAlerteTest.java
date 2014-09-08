/**
 * 
 */
package com.objectif.informatique.alerte.tests;



import com.objectif.informatique.alerte.mail.SmtpMailSender;

/**
 * @author gsoh
 *
 */
public class MailAlerteTest {
	
	public static void main(String[] args) {
		
		 String adressFrom = "alerte@objectif-informatique.fr";
		
		 String adressTo = "alerte@objectif-informatique.fr";
				 
		 String server = "smtp.googlemail.com";
		 
		 boolean enableTrace =  true;
		
		 SmtpMailSender smtpmailsender = new SmtpMailSender(server, adressFrom, adressTo, true);
		
		 smtpmailsender.sendMailSMTP(enableTrace, "Event XXXXX to be achieved, expires to date XXXXX");
		
	}

}
