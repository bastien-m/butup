package org.jeu.metier;


public class Jeu {

	
	
	/**
	 * 
	 * @param indiceDepart deplacer cette pile sur la pile arrivee
	 * @param indiceArrivee pile arrivee
	 * @throws ButupException
	 */
	/*void semer(int indiceDepart, int indiceArrivee) throws ButupException{
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
		
	}*/
	
}
