package org.jeu;

import java.util.ArrayList;
import java.util.List;

import org.jeu.Pile.Bouton;

public class Plateau {

	private static final int INDICE_MAX = 8;
	private final List<Pile> piles;
	
	Plateau(){
		piles = new ArrayList<>();
		creationPlateau();
	}
	
	Plateau(List<Pile> liste_piles){
		piles = liste_piles;
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
		
		while((indicePileArrivee !=  indicePileDepart - 1) && !depart.estVide()){
			empiler(depart, piles.get(indiceArrivee));
			
			if(indicePileArrivee == INDICE_MAX){
				indicePileArrivee = 0;
			}
			else{
				indicePileArrivee++;
			}
		}
		if(!depart.estVide()){
			depart.empiler(piles.get(correctionIndex(indiceArrivee)));
		}
		
	}
	
	void empiler(Pile aDeplacer, Pile pileReception){
		pileReception.empiler(aDeplacer.depiler());
	}
	
	
	private int correctionIndex(int indice){
		return indice - 1;
	}
	
	@Override
	public String toString(){
		return piles.toString();
	}
}
