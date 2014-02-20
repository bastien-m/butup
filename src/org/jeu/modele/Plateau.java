package org.jeu.modele;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jeu.modele.Pile.Bouton;


public class Plateau extends LinkedList<Pile>{

	private static final long serialVersionUID = -2853347309110574836L;
	private static final int NB_PILE = 9;
	private int currentPosition;
	
	public Plateau(){
		currentPosition = 0;
		creationPlateau();
		Collections.shuffle(this);
	}
	
	private void creationPlateau(){
		for(int i = 0; i < (NB_PILE / 3); i++){
			this.add(new Pile(Bouton.ROUGE));
			this.add(new Pile(Bouton.NOIRE));
			this.add(new Pile(Bouton.BLANC));
		}
	}
	
	Plateau(List<Pile> piles){
		currentPosition = 0;
		this.addAll(piles);
	}
	
	public Pile suivant(){
		Pile elementCourant = get(currentPosition);
		currentPosition++;
		if(currentPosition >= this.size()){
			currentPosition = 0;
		}
		return elementCourant;
	}
	
}
