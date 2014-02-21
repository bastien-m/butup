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
		listIterator = this.listIterator();
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
		listIterator = this.listIterator();
		this.addAll(piles);
	}
	
	public Pile suivant(){
		if(listIterator.hasNext()){
			return listIterator.next();
		}
		listIterator = this.listIterator();
		return listIterator.next();
	}
	
}
