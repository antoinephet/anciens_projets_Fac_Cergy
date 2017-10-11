package mairie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.omg.CORBA.ServiceDetail;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class EnsembleFichierXml {
	
	private ArrayList<FichierXml> xml;

	public EnsembleFichierXml() {
		
		xml = new ArrayList<FichierXml>();
	}
	
	
	public void rechercheInfosXml(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le code Insee svp :");
		String str = sc.nextLine();
		System.out.println("Vous avez saisi le nombre : " + str);
		String str1 = "mairie-";
		String str2 = "-01.xml";
		String str4 = str1 + str + str2;
		System.out.println(str4);
		System.out.println("");
		System.out.println("");
			
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		
		try {
			
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			Document document = dBuilder.parse(str4);
			document.normalize();
			
			
			// traitement et affichage des sous éléments de la balise "Organisme"
			
			NodeList rootNodes = document.getElementsByTagName("Organisme");
			Node rootNode = rootNodes.item(0);
			Element rootElement = (Element) rootNode;
			
			
			// traitement et affichage des sous éléments de la balise "Nom"
			
			NodeList nomList = rootElement.getElementsByTagName("Nom");
			Node theNom = nomList.item(0);
			
			
			
			// traitement et affichage des sous éléments de la balise "EditeurSource"
			
			NodeList editeurSourceList = rootElement.getElementsByTagName("EditeurSource");
			Node theEditeurSource = editeurSourceList.item(0);
			System.out.println("Nom de la mairie recherchée : " + nomList.item(0).getTextContent());
			System.out.println("");
			System.out.println("");
			System.out.println("L'id de la mairie : " + rootElement.getAttribute("id") + "\ncode Insee : "
			+ rootElement.getAttribute("codeInsee"));
			System.out.println("Source : " + editeurSourceList.item(0).getTextContent());
			System.out.println("");
			System.out.println("");
			
			// traitement et affichage des sous éléments de la balise "Adresse" 
			
			NodeList adresseList = rootElement.getElementsByTagName("Adresse");
			
			for(int i = 0; i < adresseList.getLength();i++){
				
				Node theAdresse = adresseList.item(i);
				Element adresseElement = (Element) theAdresse;
				
				
				Node theLigne = adresseElement.getElementsByTagName("Ligne").item(0);
				Element titleElement = (Element) theLigne;
				
				
				Node theCodePostal = adresseElement.getElementsByTagName("CodePostal").item(0);
				Element codePostalElement = (Element) theCodePostal;
				
				
				Node theNomCommune = adresseElement.getElementsByTagName("NomCommune").item(0);
				Element nomCommuneElement = (Element) theNomCommune;
				
				
				System.out.println("Adresse : " + titleElement.getTextContent());
				System.out.println( "Ville : " + nomCommuneElement.getTextContent());
				System.out.println( "Code postal : " + codePostalElement.getTextContent());
				
				NodeList rootLocal = document.getElementsByTagName("Localisation");
				Node rootNode1 = rootLocal.item(0);
				Element rootElement1 = (Element) rootNode1;
				
				
				NodeList latitudeList = rootElement1.getElementsByTagName("Latitude");
				Node theLatitude = latitudeList.item(0);
				
				
				NodeList longitudeList = rootElement1.getElementsByTagName("Longitude");
				Node theLongitude = longitudeList.item(0);
				
				System.out.println("Localisation GPS : " + longitudeList.item(0).getTextContent() + " ; " +
				latitudeList.item(0).getTextContent());
				System.out.println("");
				System.out.println("");
			}
			
			// traitement et affichage des sous éléments de la balise "Coordonnéees" 
			
			NodeList coordoneesList = rootElement.getElementsByTagName("CoordonnéesNum");
			
			for(int i = 0; i < coordoneesList.getLength();i++){
				
				Node theCoordonees = coordoneesList.item(i);
				Element coordonneesElement = (Element) theCoordonees;
				
				
				Node theTelephone = coordonneesElement.getElementsByTagName("Téléphone").item(0);
				Element telephoneElement = (Element) theTelephone;
				
				
				Node theTelecopie = coordonneesElement.getElementsByTagName("Télécopie").item(0);
				Element telecopieElement = (Element) theTelecopie;
				
				
				Node theEmail= coordonneesElement.getElementsByTagName("Email").item(0);
				Element emailElement = (Element) theEmail;
				
				
				Node theUrl = coordonneesElement.getElementsByTagName("Url").item(0);
				Element urlElement = (Element) theUrl;
				
				
				System.out.println("Nos Coordonnées pour nous contacter,\n" + "\nTél : " + 
				telephoneElement.getTextContent());
				System.out.println( "Fax : " + telecopieElement.getTextContent());
				System.out.println( "Email : " + emailElement.getTextContent());
				System.out.println( "SiteWeb : " + urlElement.getTextContent());
				System.out.println("");
				System.out.println("");
				
				
			}
			
			// traitement et affichage des sous éléments de la balise "Ouverture" 
			
			NodeList ouvertureList = rootElement.getElementsByTagName("Ouverture");
			
			for(int i = 0; i < ouvertureList.getLength();i++){
				
				Node theOuverture = ouvertureList.item(i);
				Element ouvertureElement = (Element) theOuverture;
				
				
				NodeList rootPlageJ = document.getElementsByTagName("PlageJ");
				Node rootNode2 = rootPlageJ.item(0);
				Element rootElement2 = (Element) rootNode2;
				
				
				NodeList rootPlageH = document.getElementsByTagName("PlageH");
				Node rootNode3 = rootPlageH.item(0);
				Element rootElement3 = (Element) rootNode3;
				
				System.out.println("Jour(s) d'ouverture : " + rootElement2.getAttribute("début")
						+ " - " + rootElement2.getAttribute("fin"));
				System.out.println("Horaires d'ouverture : de " + rootElement3.getAttribute("début")
						+ " à " + rootElement3.getAttribute("fin"));
				
				
			}
			
			
		} catch (ParserConfigurationException e){
			
			e.printStackTrace();
			
		} catch (SAXException e){
			e.printStackTrace();
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public void clearXml(){
		
		xml.clear();
	}
	
	public int getCurrentContactCount() {
		return xml.size();
	}
	
	
	public String toString() {
		if (getCurrentContactCount() == 0) {
			return "Aucun fichier dans ce répertoire \n";
		} else {
			String result = "";
			for (int i = 0; i <= xml.size() - 1; i++) {
				result += xml.get(i).toString() + "\n";
			}
			return result;
		}
	}
	
}
