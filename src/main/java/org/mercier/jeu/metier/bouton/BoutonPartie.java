package org.mercier.jeu.metier.bouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mercier.jeu.presentation.Interface;

public class BoutonPartie implements ActionListener {

	private Interface inter;
	
	public BoutonPartie(Interface inter){
		this.inter = inter;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inter.getNouvellePartie()){
			
		}
	}

}
