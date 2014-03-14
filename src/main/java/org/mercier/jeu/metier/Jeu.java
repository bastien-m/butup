package org.mercier.jeu.metier;

import org.mercier.jeu.exception.ButupException;
import org.mercier.jeu.modele.Joueur;
import org.mercier.jeu.modele.Pile;
import org.mercier.jeu.modele.Pile.Bouton;
import org.mercier.jeu.modele.Plateau;


public class Jeu {

	
	private Plateau plateau;
	private final Joueur j1, j2;
	
	public Jeu(Joueur j1, Joueur j2){
		this.plateau = new Plateau();
		this.j1 = j1;
		this.j2 = j2;
	}
	
	public Jeu(Plateau p, Joueur j1, Joueur j2){
		plateau = p;
		this.j1 = j1;
		this.j2 = j2;
		this.j1.setCourant(true);
		this.j2.setCourant(false);
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
	
	/**
	 * idem semer mais sans correction d'indice </hr>
	 * et sans vérification
	 * @param depart
	 * @param arrivee
	 * @return 
	 */
	boolean semerSansCorrection(int depart, int arrivee){
		boolean continuerJouer = true;
		Pile pileDepart = plateau.get(depart);
		Pile pileCourante = plateau.placerCurseur(arrivee);
		while( arrivee != depart && !pileDepart.isEmpty()){
			//appication des regles lors de la derniere pose
			continuerJouer = appliquerRegle(pileDepart, arrivee);
			pileCourante.add(pileDepart.pollFirst());
			pileCourante = plateau.suivant();
			arrivee++;
			if(arrivee >= plateau.size()){
				arrivee = 0;
			}
		}
		if(!pileDepart.isEmpty()){
			pileCourante = plateau.precedent();
			pileCourante = plateau.precedent();
			pileCourante.addAll(pileDepart);
		}
		plateau.remove(depart);
		return continuerJouer;
	}
	

	/**
	 * semer les boutons sur les piles </hr>
	 * avec correction indice pour utilisateur </hr>
	 * 1 -> 0
	 * @param indiceDepart
	 * @param indiceArrivee
	 * @return 
	 * @throws ButupException si indice hors borne
	 */
	public boolean semer(int indiceDepart, int indiceArrivee) throws ButupException{
		int depart = correctionIndice(indiceDepart);
		int arrivee = correctionIndice(indiceArrivee);
		return semerSansCorrection(depart, arrivee);
	}
	
	private int correctionIndice(int indiceACorriger) throws ButupException{
		if(indiceACorriger < 1 || indiceACorriger > plateau.size()){
			throw new ButupException("L'indice doit être compris entre 1 et "+ plateau.size());
		}
		return indiceACorriger-1;
	}
	
	boolean regleCouleur(Pile pileCourante, int indiceSuivant){
		Pile pileSuivante = null;
		if(indiceSuivant >= plateau.size()){
			indiceSuivant = 0;
		}
		pileSuivante = plateau.get(indiceSuivant);
		return pileCourante.getLast().equals(pileSuivante.getLast());
	}
	
	
	boolean reglePile(Pile pile){
		return pile.size() == 1;
	}
	
	boolean appliquerRegle(Pile pileCourante, int indiceSuivant){
		return regleCouleur(pileCourante, indiceSuivant) && reglePile(pileCourante);
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
	
	Pile getPile(int indice){
		return plateau.get(indice);
	}
	
	/**
	 * permet de calculer les scores des joueurs
	 * et retourne le perdant (qui décidera si la 
	 * partie suivante il débute ou laisse la main)
	 * @return le joueur perdant, null si ex aequo
	 */
	public Joueur setScoresJoueurs(){
		int scorej1 = setScoreJoueur(j1);
		int scorej2 = setScoreJoueur(j2);
		if(scorej1 > scorej2){
			return j2;
		}else if(scorej2 > scorej1){
			return j1;
		}
		else{
			return null;
		}
	}
	
	int setScoreJoueur(Joueur joueur){
		int scoreCourant = joueur.getScore();
		int scorePartie = plateau.getScores().get(joueur.getCouleur());
		scoreCourant+=scorePartie;
		joueur.setScore(scoreCourant);
		return scorePartie;
	}
	
	public boolean finManche(){
		return plateau.size() == 1;
	}
	
	public boolean finPartie(){
		return j1.getScore() >= 15 || j2.getScore() >= 15;
	}
	
	public void changerJoueurCourant(){
		if(j1.isCourant()){
			j1.setCourant(false);
			j2.setCourant(true);
		}
		else {
			j1.setCourant(true);
			j2.setCourant(false);
		}
	}
	
	public void setPlateau(Plateau plateau){
		this.plateau = plateau;
	}
	
	public Joueur getJoueurCourant(){
		Joueur courant;
		if(j1.isCourant()){
			courant = j1;
		}
		else{
			courant = j2;
		}
		return courant;
	}
	
	@Override
	public String toString(){
		return plateau.toString();
	}
	
	
}
