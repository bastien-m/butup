package org.mercier.jeu.presentation.console;

import java.util.Scanner;

import org.mercier.jeu.exception.ButupException;
import org.mercier.jeu.metier.Jeu;
import org.mercier.jeu.modele.Joueur;
import org.mercier.jeu.modele.Pile.Bouton;
import org.mercier.jeu.modele.Plateau;

/**
 * Implémente le jeu en console
 * @author bastien
 */
public class InterfaceConsole {

	private Scanner sc = new Scanner(System.in);
	private Jeu jeu;
	private static int compteJoueur = 1;
	
	public InterfaceConsole(){
		String joueur1 = recuperationNomJoueur();
		Bouton couleurJoueur1 = recuperationCouleur();
		String joueur2 = recuperationNomJoueur();
		while(joueur1.equals(joueur2)){
			joueur2 = recuperationNomJoueur();
		}
		Bouton couleurJoueur2 = recuperationCouleur();
		jeu = new Jeu(new Plateau(), new Joueur(joueur1, couleurJoueur1), 
									 new Joueur(joueur2, couleurJoueur2));
		
	}
	
	String recuperationNomJoueur(){
		System.out.println("Nom du joueur "+ compteJoueur);
		return sc.nextLine();
	}
	
	Bouton recuperationCouleur(){
		Bouton reponse = null;
		System.out.println("Couleur du joueur "+compteJoueur++);
		System.out.println("Choix : NOIRE ou ROUGE");
		String ligne = sc.nextLine();
		if(!ligne.equals("NOIRE") && !ligne.equals("ROUGE")){
			compteJoueur--;
			reponse = recuperationCouleur();
		}
		if(ligne.equals("NOIRE")){
			reponse = Bouton.NOIRE;
		}
		else if(ligne.equals("ROUGE")){
			reponse = Bouton.ROUGE;
		}
		return reponse;
	}
	
	public String afficheSituationInitiale(){
		String reponse = jeu.getJoueur1().toString();
		reponse+="\n";
		reponse+= jeu.getJoueur2().toString();
		return reponse;
	}
	
	Joueur jouerManche(){
		Joueur perdant = null;
		while(!jeu.finManche()){
			demanderJeu();
		}
		perdant = jeu.setScoresJoueurs();
		System.out.println(jeu.getPlateau());
		afficherScore(perdant);
		return perdant;
	}
	
	private void afficherScore(Joueur perdant){
		System.out.println("Fin de manche");
		if(perdant.equals(jeu.getJoueur1())){
			System.out.println("Gagnant : " + jeu.getJoueur2());
			System.out.println("Total points " + jeu.getJoueur2().getNom() 
					+ " : " + jeu.getJoueur2().getScore());
			System.out.println("Total points " + jeu.getJoueur1().getNom() 
					+ " : " + jeu.getJoueur1().getScore());
		}
	}
	
	/**
	 * a chaque fin de manche on demande au perdant
	 * qui debute la manche suivante
	 */
	private void demanderJoueurCourant(Joueur perdant){
		if(perdant == null){
			//ex aequo
			jeu.getJoueur1().setCourant(true);
			jeu.getJoueur2().setCourant(false);
		}
		else{
			System.out.println(perdant.getNom() + "! Qui débute la partie ? ");
			System.out.println("1 : " + jeu.getJoueur1().getNom());
			System.out.println("2 : " + jeu.getJoueur2().getNom());
			try{
				int joueurSaisie = verifierSaisie(sc.nextLine());
				if(joueurSaisie != 1 && joueurSaisie != 2){
					System.out.println("1 ou 2");
					demanderJoueurCourant(perdant);
				}
				else{
					if(joueurSaisie == 1){
						jeu.getJoueur1().setCourant(true);
						jeu.getJoueur2().setCourant(false);
					}
					else{
						jeu.getJoueur1().setCourant(false);
						jeu.getJoueur2().setCourant(true);
					}
				}
			}
			catch(ButupException e){
				System.out.println(e.getMessage());
				demanderJoueurCourant(perdant);
			}
		}
		
	}
	
	public void jouer(){
		Plateau nouveau_plateau;
		Joueur perdant = null;
		while(!jeu.finPartie()){
			perdant = jouerManche();
			demanderJoueurCourant(perdant);
			//a la fin de la manche, on refait un nouveau plateau
			nouveau_plateau = new Plateau();
			jeu.setPlateau(nouveau_plateau);
		}
	}
	
	private void demanderJeu(){
		System.out.println(jeu.getPlateau());
		int indiceDepart, indiceArrivee;
		try{
			System.out.println("Joueur " + jeu.getJoueurCourant().getNom() + " joue : ");
			System.out.println("Pile de départ : ");
			indiceDepart = verifierSaisie(sc.nextLine());
			System.out.println("Pile d'arrivee : ");
			indiceArrivee = verifierSaisie(sc.nextLine());
			if(jeu.semer(indiceDepart, indiceArrivee)){
				System.out.println("Vous pouvez continuer à jouer :)");
				demanderJeu();
			}else{
				jeu.changerJoueurCourant();
			}
		}catch(ButupException be){
			System.out.println(be.getMessage());
			demanderJeu();
		}
	}
	
	private int verifierSaisie(String ligne) throws ButupException{
		int valeurSaisie;
		try{
			valeurSaisie = Integer.valueOf(ligne);
		}
		catch(NumberFormatException e){
			throw new ButupException("Vous devez saisir un nombre");
		}
		return valeurSaisie;
	}
	
}
