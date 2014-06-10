/**
 * 
 */
package com.objectif.informatique.alerte.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;

/**
 * @author choupi
 * 
 */
@Path("/WebService")
public class EvenementRestService {

	@GET
	@Path("/GetEvent")
	@Produces("application/json")
	public String feed() {
		String feeds = null;
		try {
			System.out.println("******************************");
			// ArrayList<String> evenements = null;
			// JdbcEvenementDAO evenementDAO = null;

			// ArrayList<String> evenements = null;
			// ApplicationContext context = new
			// ClassPathXmlApplicationContext("Spring-Module.xml");
			// JdbcEvenementDAO jdbcEvenementDAO = (JdbcEvenementDAO)
			// context.getBean("evenementDAO");

			// JdbcEvenementDAO jdbcEvenementDAO = null;
			// ArrayList<String> evenement =
			// jdbcEvenementDAO.selectedAllEvenementByName();
			// System.out.println("evenement : " + evenement);
			// //ArrayList<String> evenement =
			// evenementDAO.selectedAllEvenementByName();
			// Gson gson = new Gson();
			// System.out.println(gson.toJson(evenement));
		}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return feeds;
	}

}