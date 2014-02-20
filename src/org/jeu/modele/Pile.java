package org.jeu.modele;

import java.util.ArrayList;
import java.util.List;

import org.jeu.modele.Pile.Bouton;


public class Pile extends ArrayList<Bouton>{

	private static final long serialVersionUID = 8591227950719216099L;

	public static enum Bouton {
		BLANC { @Override Bouton adversaire(){ return BLANC;}},
		NOIRE { @Override Bouton adversaire(){ return ROUGE;}},
		ROUGE { @Override Bouton adversaire(){ return NOIRE;}};
		abstract Bouton adversaire();
	}
	
	public Pile(){
		super();
	}
	
	public Pile(Bouton couleur){
		this.add(couleur);
	}
	
	
	Pile(List<Bouton> boutons){
		super(boutons);
	}
	
	
}
