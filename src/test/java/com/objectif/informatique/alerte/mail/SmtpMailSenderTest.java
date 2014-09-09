package com.objectif.informatique.alerte.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SmtpMailSenderTest {
	
	static SmtpMailSender smtpmailsender = new SmtpMailSender();
	
	
	
	@BeforeClass
	public static void setArgs () {
		smtpmailsender.setAdressFrom("alerte@objectif-informatique.fr");
		smtpmailsender.setAdressTo("alerte@objectif-informatique.fr");
		smtpmailsender.setServer("smtp.googlemail.com");
		smtpmailsender.setSmtpAuthEnable(true);
	}
	
	
	@Test
	public void testAgrs() {
		assertNotNull("From adress not defined", smtpmailsender.getAdressFrom());
		assertNotNull("To adress not defined", smtpmailsender.getAdressTo());
		assertNotNull("Mail Server not defined", smtpmailsender.getServer());
		assertTrue("Authentication not enabled", smtpmailsender.isSmtpAuthEnable());
		assertNotSame("From and To adresses", smtpmailsender.getAdressFrom(), smtpmailsender.getAdressTo());
	}
	
	@Test
	public void testSendMail() {
		assertEquals("Mail not sent", true, smtpmailsender.sendMailSMTP(true, "Alerte"));
	}

}
