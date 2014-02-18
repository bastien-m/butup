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
	
	public Pile(Bouton bouton){
		pile = new ArrayList<>();
		pile.add(bouton);
	}
	
	
	public Pile(List<Bouton> piles){
		this.pile = piles;
	}
	
	
	void empiler(Pile pile){
		this.pile.addAll(pile.getPile());
	}
	
	void empiler(Pile.Bouton bouton){
		this.pile.add(bouton);
	}
	
	
	List<Bouton> getPile(){
		return this.pile;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pile == null) ? 0 : pile.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pile other = (Pile) obj;
		if (pile == null) {
			if (other.pile != null)
				return false;
		} else if (!pile.equals(other.pile))
			return false;
		return true;
	}
	
	boolean pileJouable(){
		for(Pile.Bouton bouton : pile){
			if(bouton == Pile.Bouton.BLANC)
				return true;
		}
		return false;
	}

	Bouton depiler(){
		int indiceMax = pile.size() - 1;
		return pile.remove(indiceMax);
	}

	boolean estVide(){
		return pile.isEmpty();
	}
	
	@Override
	public String toString(){
		return this.pile.toString();
	}
}
