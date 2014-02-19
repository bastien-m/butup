package org.jeu;

public class Jeu {

	private Joueur j1;
	private Joueur j2;
	private Plateau plateau;
	
	public Jeu(Joueur joueur1, Joueur joueur2){
		j1 = joueur1;
		j2 = joueur2;
		verificationCouleur();
		plateau = new Plateau();
	}
	
	void verificationCouleur(){
		if(j1.getCouleur().equals(j2.getCouleur())){
			j2.setCouleur(j1.getCouleur().adversaire());
		}
	}
	
	public Joueur getJoueur1(){
		return j1;
	}
	
	public Joueur getJoueur2(){
		return j2;
	}
	
	
	
}
