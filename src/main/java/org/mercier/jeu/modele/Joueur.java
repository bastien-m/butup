package org.mercier.jeu.modele;

import org.mercier.jeu.modele.Pile.Bouton;


public class Joueur {

	private int score;
	private final String nom;
	private Bouton couleur;
	private boolean courant;
	
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
	
	public boolean isCourant() {
		return courant;
	}

	public void setCourant(boolean courant) {
		this.courant = courant;
	}

	@Override
	public String toString(){
		return (getNom() + " , couleur : " + getCouleur() + " , score : " 
				+ getScore());
	}
}
