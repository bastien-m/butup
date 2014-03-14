package org.mercier.jeu.metier;

import java.awt.Point;
import java.util.ArrayList;

import org.mercier.jeu.exception.ButupException;
import org.mercier.jeu.modele.Plateau;

public class GestionClickPlateau {

	private boolean premierClick;
	private ArrayList<Point> positions;
	private int x,y;
	private int largeur, hauteur;
	private int indiceDepart, indiceArrivee;
	private Jeu jeu;
	
	public GestionClickPlateau(int largeur, int hauteur, Jeu jeu){
		premierClick = true;
		this.largeur = largeur;
		this.hauteur = hauteur;
		indiceDepart = -1; indiceArrivee = -1;
		this.jeu = jeu;
	}
	
	public void traitement(int x, int y) throws ButupException{
		this.x = x; this.y = y;
		int indice;
		if(premierClick && (indice = clickSurObjet()) != -1){
			indiceDepart = indice;
			premierClick = !premierClick;
		}
		else if(!premierClick && (indice = clickSurObjet()) != -1){
			indiceArrivee = indice;
			semerPile();
			indiceDepart = -1; indiceArrivee = -1;
			premierClick = !premierClick;
		}
		
		System.out.println(jeu.getPlateau());
	}
	
	private void semerPile() throws ButupException{
		System.out.println("indiceDepart : " + indiceDepart + ", " + indiceArrivee);
		jeu.semer(indiceDepart, indiceArrivee);
	}
	
	public void setPositions(ArrayList<Point> positions){
		this.positions = positions;
	}
	
	private int clickSurObjet(){
		int indice = 0;
		for(Point p : positions){
			if(x >= p.x && x <= (p.x + largeur)){
				if(y >= p.y  && y <= (p.y + hauteur)){
					return indice;
				}
			}
			indice++;
		}
		return -1;
	}
}
