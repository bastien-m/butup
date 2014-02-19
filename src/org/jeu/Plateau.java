package org.jeu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeu.Pile.Bouton;
import org.jeu.exception.ButupException;

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
	
	/**
	 * 
	 * @param indiceDepart deplacer cette pile sur la pile arrivee
	 * @param indiceArrivee pile arrivee
	 * @throws ButupException
	 */
	void semer(int indiceDepart, int indiceArrivee) throws ButupException{
		int indicePileDepart  = correctionIndex(indiceDepart);
		int indicePileArrivee = correctionIndex(indiceArrivee);
		
		Pile depart = piles.get(indicePileDepart);
		
		while((indicePileArrivee !=  indicePileDepart - 1) && !depart.estVide()){
			empiler(depart, piles.get(indicePileArrivee));
			
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
		
		this.piles.remove(correctionIndex(indiceDepart));
		
	}
	
	/**
	 * @param aDeplacer empile cette pile sur pileReception
	 * @param pileReception pile recevant
	 */
	void empiler(Pile aDeplacer, Pile pileReception){
		pileReception.empiler(aDeplacer.depiler());
	}
	
	Pile recupererPile(int indice) throws ButupException{
		try {
			return piles.get(correctionIndex(indice));
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new ButupException("Indice incorrect: doit être compris entre 1 et " + piles.size());
		}
		
	}
	
	
	private int correctionIndex(int indice) throws ButupException{
		if(indice < 1 && indice > piles.size())
			throw new ButupException();
		return indice - 1;
	}
	
	@Override
	public String toString(){
		return piles.toString();
	} 
	
	boolean termine(){
		return this.piles.size() == 1;
	}
	
	Map<Pile.Bouton, Integer> calculPoint() throws ButupException{
		if(!termine()){
			throw new ButupException("La partie n'est pas finie");
		}
		HashMap<Pile.Bouton, Integer> map = new HashMap<>();
		map.put(Pile.Bouton.ROUGE, calculPointRouge());
		map.put(Pile.Bouton.NOIRE, calculPointNoire());
		
		return map;
	}
	
	private int calculPointRouge(){
		int score = 0;
		Pile pileTerminal = piles.get(0);
		
	}
	
	private int calculPointNoire(){
		int score = 0;
		Pile pileTerminal = piles.get(0);
		
	}
}
