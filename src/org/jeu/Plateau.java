package org.jeu;

import java.util.ArrayList;
import java.util.List;

import org.jeu.Pile.Bouton;

public class Plateau {

	private static final int INDICE_MAX = 8;
	private List<Pile> piles;
	
	Plateau(){
		piles = new ArrayList<>();
		creationPlateau();
	}
	
	void creationPlateau(){
		for(int i = 0; i < 3; i++){
			piles.add(new Pile(Bouton.NOIRE));
			piles.add(new Pile(Bouton.ROUGE));
			piles.add(new Pile(Bouton.BLANC));
		}
	}
	
	void semer(int indiceDepart, int indiceArrivee){
		int indicePileDepart  = correctionIndex(indiceDepart);
		int indicePileArrivee = correctionIndex(indiceArrivee);
		
		Pile depart = piles.get(indicePileDepart);
		Pile Arrivee = piles.get(indicePileArrivee);
		
		//6 4 --> 7 8 0 1 2 3 4
		boolean estTermine = false;
		while(indiceDepart != indiceArrivee){
			if(indiceDepart == INDICE_MAX){
				
			}
		}
		
	}
	
	private int correctionIndex(int indice){
		return indice - 1;
	}
	
	public String toString(){
		return piles.toString();
	}
}
