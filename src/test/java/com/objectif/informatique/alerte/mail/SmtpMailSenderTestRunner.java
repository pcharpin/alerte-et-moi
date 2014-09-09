package com.objectif.informatique.alerte.mail;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//@RunWith(Suite.class)
//@SuiteClasses({ SmtpMailSenderTest.class })
public class SmtpMailSenderTestRunner {
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(SmtpMailSenderTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }

}
