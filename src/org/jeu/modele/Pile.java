package org.jeu.modele;

import java.util.LinkedList;
import java.util.List;

import org.jeu.modele.Pile.Bouton;


public class Pile extends LinkedList<Bouton>{

	private static final long serialVersionUID = 8591227950719216099L;

	public static enum Bouton {
		BLANC { @Override public Bouton adversaire(){ return BLANC;}},
		NOIRE { @Override public Bouton adversaire(){ return ROUGE;}},
		ROUGE { @Override public Bouton adversaire(){ return NOIRE;}};
		public abstract Bouton adversaire();
	}
	
	public Pile(){
		super();
	}
	
	public Pile(Bouton couleur){
		this.offer(couleur);
	}
	
	
	Pile(List<Bouton> boutons){
		super(boutons);
	}
	
	
}
