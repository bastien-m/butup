package org.mercier.jeu.DAO;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturePropXML {

	private String raccourciConnexion;
	private String raccourciNouvellePartie;
	private String raccourciReorganiser;
	private Document fichierXML;
	
	public LecturePropXML(String nom) throws ParserConfigurationException, SAXException, IOException{
		File fXmlFile = new File(nom);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		fichierXML = dBuilder.parse(fXmlFile);
		fichierXML.getDocumentElement().normalize();
		
		getShortcuts();
	}
	
	private void getShortcuts(){
		String os = System.getProperty("os.name");
		NodeList systems = fichierXML.getElementsByTagName("system");
		for(int i = 0 ; i < systems.getLength(); i++){
			Element config = (Element)systems.item(i);
			
			if(os.contains("Mac") && config.getAttribute("id").equals("Mac")){
				raccourciConnexion = config.getElementsByTagName("connexion").item(0).getTextContent();
				raccourciNouvellePartie = config.getElementsByTagName("nouvellePartie").item(0).getTextContent();
				raccourciNouvellePartie = config.getElementsByTagName("reorganiser").item(0).getTextContent();
			}
			else{
				raccourciConnexion = config.getElementsByTagName("connexion").item(0).getTextContent();
				raccourciNouvellePartie = config.getElementsByTagName("nouvellePartie").item(0).getTextContent();
				raccourciNouvellePartie = config.getElementsByTagName("reorganiser").item(0).getTextContent();
			}
		}
	}

	public String getRaccourciConnexion() {
		return raccourciConnexion;
	}

	public String getRaccourciNouvellePartie() {
		return raccourciNouvellePartie;
	}
	
	public String getRaccourciReorganiser(){
		return raccourciReorganiser;
	}
}
