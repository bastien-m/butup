package org.mercier.jeu.presentation.graphique;

import org.mercier.jeu.metier.Jeu;
import org.mercier.jeu.modele.Joueur;
import org.mercier.jeu.modele.Pile.Bouton;


public class InstanceInterface {

	public static void main(String[] args) {
		try{
			Jeu jeu = new Jeu(new Joueur("Bastien", Bouton.NOIRE), new Joueur("Claudy", Bouton.ROUGE));
			new Interface(jeu);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
