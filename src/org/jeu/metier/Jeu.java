package org.jeu.metier;

import org.jeu.modele.Joueur;
import org.jeu.modele.Pile;
import org.jeu.modele.Pile.Bouton;
import org.jeu.modele.Plateau;


public class Jeu {

	
	private final Plateau plateau;
	private final Joueur j1, j2;
	private Pile pileCourante;
	
	public Jeu(Plateau p, Joueur j1, Joueur j2){
		plateau = p;
		this.j1 = j1;
		this.j2 = j2;
		correctionCouleur();
	}
	
	void correctionCouleur(){
		if(j1.getCouleur().equals(Bouton.BLANC)){
			j1.setCouleur(Bouton.ROUGE);
		}
		if(j2.getCouleur().equals(Bouton.BLANC)){
			j2.setCouleur(j1.getCouleur().adversaire());
		}
		if(j1.getCouleur().equals(j2.getCouleur())){
			j2.setCouleur((j1.getCouleur()).adversaire());
		}
	}
	
	public void semer(int depart, int arrivee){
		Pile pileDepart = plateau.get(depart);
		avancerCurseur(plateau.get(arrivee));
		while(!pileCourante.equals(plateau.get(depart))){
			pileCourante.add(pileDepart.pollLast());
		}
	}
	
	private Pile avancerCurseur(Pile arrivee){
		while(!(pileCourante = plateau.suivant()).equals(arrivee)){}
		return pileCourante;
	}
	
	public Plateau getPlateau(){
		return this.plateau;
	}

	public Joueur getJoueur1() {
		return j1;
	}

	public Joueur getJoueur2() {
		return j2;
	}
}
