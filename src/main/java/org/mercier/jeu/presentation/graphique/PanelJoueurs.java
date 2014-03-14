package org.mercier.jeu.presentation.graphique;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelJoueurs extends JPanel {

	private static final long serialVersionUID = 1103525421532267580L;
	private TitledBorder borderMoi;
	private TitledBorder borderAdversaire;
	private JPanel panelJoueur1;
	private JPanel panelJoueur2;
	private JLabel scoreJoueur1;
	private JLabel scoreJoueur2;

	public PanelJoueurs(){
		borderMoi = BorderFactory.createTitledBorder("Moi");
		borderAdversaire = BorderFactory.createTitledBorder("Adversaire");
		
		setLayout(new GridLayout(2,1));
		panelJoueur1 = new JPanel(new GridLayout(2,1));
		panelJoueur2 = new JPanel(new GridLayout(2,1));
		panelJoueur1.setBorder(borderMoi);
		panelJoueur2.setBorder(borderAdversaire);
		add(panelJoueur1);
		add(panelJoueur2);
		
		scoreJoueur1 = new JLabel("Score: ");
		
		scoreJoueur2 = new JLabel("Score: ");
		
		panelJoueur1.add(scoreJoueur1);
		panelJoueur2.add(scoreJoueur2);
		
		setPreferredSize(new Dimension(100,200));	
	}
	
}
