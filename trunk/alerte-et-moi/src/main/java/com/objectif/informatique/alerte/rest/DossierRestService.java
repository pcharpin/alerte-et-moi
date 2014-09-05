package com.objectif.informatique.alerte.rest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.objectif.informatique.alerte.model.Document;
import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.service.DocumentService;
import com.objectif.informatique.alerte.service.DossierService;

@Component
@Path("/dossier")
public class DossierRestService {
	
	@Autowired
	DossierService service;
	
	@Value("${alerte.file.root.dir}")
	String rootPath ;
	
	@Autowired
	DocumentService docService;
	

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Dossier getFolder(@PathParam("id") int id) {
		return service.getDossierById(id);
	}
	
	@GET
	@Path("/folder/{name}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Dossier getFolderByName(@PathParam("name") String dossier) {
		return service.getFolderByName(dossier);
	}
	
	@GET
	@Path("/getFolders")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Dossier> getAllFolders() throws Exception {
		List<Dossier> dossiers = service.findAll();
		return dossiers;
	}	
	/**
	 * 	
	 * @param dossier
	 * @return
	 */
	@POST
	@Path("/sendFolder")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response add(Dossier dossier){	
		
		System.out.println("******dossier:****" + dossier);
		
//		String [] datas =  dossier.getDocumentContents();
//		String [] datasNames = dossier.getDocumentNames();
//		
//		System.out.println("***********************");
//		System.out.println("******datas:****" + datas);
//		System.out.println("******datasNames:****" + datasNames);
//		System.out.println("***********************");
		
//		for (int i = 0; i < datas.length; i++) {			
//			String data = datas[i];
//			String dataName = datasNames[i];
//			
//		//Chemin à modifier (mettre le chemin du server)
//		String path = rootPath + dataName;
//		try {
//			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
//			dos.writeBytes(data);
//			dos.close();
//			
//			//Création d'un objet document
//			Document doc = new Document();
//			doc.setLienDoc(path);
//			docService.create(doc);
//			
//			if(dossier.getDocuments() == null){
//				//dossier.setDocuments( new HashSet<Document>());
//				dossier.setDocuments( new HashSet<Document>());
//			}
//			dossier.getDocuments().add(doc);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}			
		service.create(dossier);		
		return Response.status(200).entity(dossier).build();
	}
	
	@POST
	@Path("/{id}")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public  Response updateFolder(@PathParam("id") int id){
		 Dossier dossier =  service.getDossierById(id);
		service.update(dossier);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response deleteFolder(@PathParam("id") int id){
		Dossier dossier =  service.getDossierById(id);
		service.delete(dossier);
		return Response.ok().build();
	}
}