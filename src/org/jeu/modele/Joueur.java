package org.jeu.modele;

import org.jeu.modele.Pile.Bouton;


public class Joueur {

	private int score;
	private final String nom;
	private Bouton couleur;
	
	public Joueur(String nom, Bouton couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}

	public Bouton getCouleur(){
		return couleur;
	}
	
	public void setCouleur(Bouton couleur){
		this.couleur = couleur;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	
}
