package org.mercier.jeu.presentation;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Interface extends JFrame{

	private static final long serialVersionUID = 1L;

	
	private JMenuBar barMenu;
	private JMenu partie;
	private JMenuItem nouvellePartie;
	private JMenuItem connexion;
	
	public Interface(){
		super("Button Up Game");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		
		barMenu = new JMenuBar();
		
		partie = new JMenu("Jeu");
		connexion = new JMenuItem("Connexion");
		connexion.setAccelerator(KeyStroke.getKeyStroke("meta alt C"));
		partie.add(connexion);
		
		nouvellePartie = new JMenuItem("Nouvelle Partie");
		nouvellePartie.setAccelerator(KeyStroke.getKeyStroke("meta N"));
		partie.add(nouvellePartie);
		barMenu.add(partie);
		
		
		setJMenuBar(barMenu);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JMenuItem getNouvellePartie() {
		return nouvellePartie;
	}
	
}
