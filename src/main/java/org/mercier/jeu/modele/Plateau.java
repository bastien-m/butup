package org.mercier.jeu.modele;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.mercier.jeu.exception.ButupRunTimeException;
import org.mercier.jeu.modele.Pile.Bouton;


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
	
	public Plateau(List<Pile> piles){
		this.addAll(piles);
		listIterator = this.listIterator();
	}
	
	public Pile placerCurseur(int indice){
		Pile courante = suivant();
		for(int i = 0; i < indice; i++){
			courante = suivant();
		}
		return courante;
	}
	
	@Override
	public Pile remove(int indice){
		Pile tmp = super.remove(indice);
		listIterator = listIterator();
		return tmp;
	}
	
	public Pile suivant(){
		Pile suivant = listIterator.next();
		if(!listIterator.hasNext()){
			listIterator = this.listIterator();
		}
		return suivant;
	}
	
	public Pile precedent(){
		Pile tmp = null;
		if(listIterator.hasPrevious()){
			tmp = listIterator.previous();
		}
		else{
			while(listIterator.hasNext()){
				tmp = listIterator.next();
			}
			tmp = listIterator.previous();
		}
		return tmp;
	}
	
	public Map<Bouton, Integer> getScores() throws ButupRunTimeException{
		if(size() != 1){
			throw new ButupRunTimeException("Impossible de calculer le score si la partie n'est pas finie");
		}
		return get(0).getScores();
	}
}
