package org.jeu;

import java.util.ArrayList;
import java.util.List;

public class Pile {

	public static enum Bouton {
		BLANC { @Override Bouton adversaire(){ return BLANC;}},
		NOIRE { @Override Bouton adversaire(){ return ROUGE;}},
		ROUGE { @Override Bouton adversaire(){ return NOIRE;}};
		abstract Bouton adversaire();
	}
	
	private List<Bouton> pile;
	
	public Pile(Pile.Bouton bouton){
		pile = new ArrayList<>();
		pile.add(bouton);
	}
	
	
	public Pile(ArrayList<Bouton> piles){
		this.pile = piles;
	}
	
	
	void empiler(Pile pile){
		this.pile.addAll(pile.getPile());
	}
	
	List<Bouton> getPile(){
		return this.pile;
	}
	
	@Override
	public String toString(){
		return this.pile.toString();
	}
}
