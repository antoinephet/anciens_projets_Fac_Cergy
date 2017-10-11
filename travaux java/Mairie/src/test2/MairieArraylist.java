package test2;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;



public class MairieArraylist {
	
	private  ArrayList<Mairie> MairieList = new ArrayList<Mairie>();
	
	
	// Parcourt les fichiers xml, ajoute les données à L'ArrayList, puis les affiche
	public void ajouter(){
		
		Document document = null;
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		MairieList = new ArrayList<Mairie>();
		//Chemin de location du jeu de donnees reduit
		String pat = "C:\\Users\\PHETRAMPHAND\\Desktop\\jeu_de_donnees_reduit";
		File di   = new File(pat);
		String[] fl = di.list();
		int j;
		String filename;
		String name, insee, postalCode, phone, mail, website; 

		for (j=0; j < fl.length; j++)
		{
			filename=""+fl[j];
			System.out.println(""+filename);
			if (!filename.startsWith("mairie") || !filename.endsWith(".xml")) continue;
			
			
			try{
				factory = DocumentBuilderFactory.newInstance();
				builder = factory.newDocumentBuilder();
				document = builder.parse(pat +"\\" + filename);
				name = document.getElementsByTagName("Nom").item(0).getTextContent();
				insee = document.getElementsByTagName("Organisme").item(0).getAttributes().item(0).getNodeValue();
				postalCode = document.getElementsByTagName("CodePostal").item(0).getTextContent();
				phone = document.getElementsByTagName("Téléphone").item(0).getTextContent();
				if (document.getElementsByTagName("Email").getLength()>0) {
					mail = document.getElementsByTagName("Email").item(0).getTextContent();
				} else mail = "";
				if (document.getElementsByTagName("Url").getLength()>0) {
					website = document.getElementsByTagName("Url").item(0).getTextContent();
				} else website = "";
				Mairie mai = new Mairie(name, insee,postalCode,phone,mail,website);
				MairieList.add(mai);
				
				System.out.println(mai.toString());
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			 
			
			}
		
		
	}
	

}
