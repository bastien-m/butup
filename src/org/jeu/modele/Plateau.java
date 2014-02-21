package org.jeu.modele;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.jeu.modele.Pile.Bouton;


public class Plateau extends LinkedList<Pile>{

	private static final long serialVersionUID = -2853347309110574836L;
	private static final int NB_PILE = 9;
	private ListIterator<Pile> listIterator;
	
	public Plateau(){
		creationPlateau();
		Collections.shuffle(this);
		listIterator = this.listIterator();
	}
	
	private void creationPlateau(){
		for(int i = 0; i < (NB_PILE / 3); i++){
			this.add(new Pile(Bouton.ROUGE));
			this.add(new Pile(Bouton.NOIRE));
			this.add(new Pile(Bouton.BLANC));
		}
	}
	
	Plateau(List<Pile> piles){
		this.addAll(piles);
		listIterator = this.listIterator();
	}
	
	public Pile suivant(){
		Pile suivant = listIterator.next();
		if(listIterator.hasNext()){
			return suivant;
		}
		listIterator = this.listIterator();
		return suivant;
	}
	
	public Pile precedent(){
		if(listIterator.hasPrevious()){
			return listIterator.previous();
		}
		else{
			return this.getLast();
		}
	}
}
