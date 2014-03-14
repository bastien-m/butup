package org.mercier.jeu.presentation.graphique;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.mercier.jeu.DAO.LecturePropXML;

public class BarMenu extends JMenuBar {

	private static final long serialVersionUID = 5315469753627182050L;
	private JMenu partie;
	private JMenu plateau;
	private JMenuItem connexion;
	private JMenuItem nouvellePartie;
	private JMenuItem reorganiser;
	
	public BarMenu(LecturePropXML lectureXML){
		setBackground(Color.gray);
		
		partie = new JMenu("Jeu");
		partie.setBackground(Color.gray);
		connexion = new JMenuItem("Connexion");
		connexion.setAccelerator(KeyStroke.getKeyStroke(lectureXML.getRaccourciConnexion()));
		partie.add(connexion);
		
		nouvellePartie = new JMenuItem("Nouvelle Partie");
		nouvellePartie.setAccelerator(KeyStroke.getKeyStroke(lectureXML.getRaccourciNouvellePartie()));

		partie.add(nouvellePartie);
		
		plateau = new JMenu("Plateau");
		plateau.setBackground(Color.gray);
		reorganiser = new JMenuItem("Ré-organiser");
		reorganiser.setAccelerator(KeyStroke.getKeyStroke(lectureXML.getRaccourciReorganiser()));
		plateau.add(reorganiser);
		
		
		add(partie);
		add(plateau);
	}
}
