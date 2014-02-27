package org.mercier.jeu.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

public class Interface extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 200;
	
	private JMenuBar barMenu;
	private JMenu partie;
	private JMenuItem nouvellePartie;
	private JMenuItem connexion;
	
	private JPanel panelJoueurs;
	private JPanel panelPlateau;
	private JPanel panelJoueur1;
	private JPanel panelJoueur2;
	
	private JLabel scoreJoueur1;
	private JLabel scoreJoueur2;
	
	private JLabel plateau;
	
	private TitledBorder borderMoi;
	private TitledBorder borderAdversaire;
	
	public Interface(){
		super("Button Up Game");
		setSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		setIconImage(new ImageIcon("ressources/icon.png").getImage());
		
		barMenu = new JMenuBar();
		barMenu.setBackground(Color.gray);
		
		partie = new JMenu("Jeu");
		partie.setBackground(Color.gray);
		connexion = new JMenuItem("Connexion");
		connexion.setAccelerator(KeyStroke.getKeyStroke("meta alt C"));
		partie.add(connexion);
		
		nouvellePartie = new JMenuItem("Nouvelle Partie");
		nouvellePartie.setAccelerator(KeyStroke.getKeyStroke("meta N"));
		partie.add(nouvellePartie);
		barMenu.add(partie);
		
		setJMenuBar(barMenu);
		
		borderMoi = BorderFactory.createTitledBorder("Moi");
		borderAdversaire = BorderFactory.createTitledBorder("Adversaire");
		
		panelJoueurs = new JPanel(new GridLayout(2,1));
		panelJoueur1 = new JPanel(new GridLayout(2,1));
		panelJoueur2 = new JPanel(new GridLayout(2,1));
		panelJoueur1.setBorder(borderMoi);
		panelJoueur2.setBorder(borderAdversaire);
		panelJoueurs.add(panelJoueur1);
		panelJoueurs.add(panelJoueur2);
		
		scoreJoueur1 = new JLabel("Score: ");
		
		scoreJoueur2 = new JLabel("Score: ");
		
		panelJoueur1.add(scoreJoueur1);
		panelJoueur2.add(scoreJoueur2);
		
		panelJoueurs.setPreferredSize(new Dimension(100,200));
		add(panelJoueurs, BorderLayout.EAST);

		panelPlateau = new JPanel(new BorderLayout());
		panelPlateau.setPreferredSize(new Dimension(300,100));
		plateau = new JLabel();
		plateau.setIcon(new ImageIcon("ressources/wood.jpg"));
		panelPlateau.add(plateau);
		add(panelPlateau);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JMenuItem getNouvellePartie() {
		return nouvellePartie;
	}
	
}
