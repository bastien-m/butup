package org.mercier.jeu.modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mercier.jeu.modele.Pile.Bouton;


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
	
	Map<Bouton, Integer> getScores(){
		HashMap<Bouton, Integer> scores = new HashMap<>();
		int scoreRouge = calculScore(Bouton.ROUGE);
		int scoreNoire = calculScore(Bouton.NOIRE);
		if(scoreRouge > scoreNoire){
			scores.put(Bouton.ROUGE, calculScore(Bouton.ROUGE) - calculScore(Bouton.NOIRE));
			scores.put(Bouton.NOIRE, 0);
		}
		else if(scoreNoire > scoreRouge){
			scores.put(Bouton.NOIRE, calculScore(Bouton.NOIRE) - calculScore(Bouton.ROUGE));
			scores.put(Bouton.ROUGE, 0);
		}
		else {
			//match nul
			scores.put(Bouton.NOIRE, 0);
			scores.put(Bouton.ROUGE, 0);
		}
		
		return scores;
	}
	
	private int calculScore(Bouton couleur){
		int score = 0;
		for(int i = 0; i < size(); i++){
			if(get(i).equals(couleur)){
				score+=(i+1);
			}
		}
		return score;
	}
}
