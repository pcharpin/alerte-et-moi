package com.objectif.informatique.alerte.tests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGetProfilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client client = Client.create();
			// All proil
			WebResource webResource = client
					.resource("http://localhost:8080/alerte-et-moi/rest/profil/getallProfil");
			// By id
			// WebResource webResource =
			// client.resource("http://localhost:8080/alerte-et-moi/rest/profil/1");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
