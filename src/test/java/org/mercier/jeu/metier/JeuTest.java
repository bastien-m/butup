package org.mercier.jeu.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mercier.jeu.exception.ButupException;
import org.mercier.jeu.modele.Joueur;
import org.mercier.jeu.modele.Pile;
import org.mercier.jeu.modele.Pile.Bouton;
import org.mercier.jeu.modele.Plateau;

public class JeuTest {

	private Jeu jeu;
	
	@Before
	public void setUp() throws Exception {
		jeu = new Jeu(new Plateau(), new Joueur("Bastien", Bouton.ROUGE), new Joueur("Claudy", Bouton.ROUGE));
	}

	@Test
	public void testCorrectionCouleur() {
		Bouton couleurJ1 = jeu.getJoueur1().getCouleur();
		Bouton couleurJ2 = jeu.getJoueur2().getCouleur();
		assertFalse(couleurJ1.equals(couleurJ2));
		assertEquals(Bouton.NOIRE, couleurJ2);
	}

	@Test
	public void avancerCurseur(){
		Plateau p = jeu.getPlateau();
		int indiceATester = 5;
		Pile courante = p.placerCurseur(indiceATester);
		assertEquals(courante, jeu.getPile(indiceATester));		
	}
	
	@Test
	public void testRegleCouleur() {
		Pile pile = new Pile(Bouton.ROUGE);
		pile.add(Bouton.NOIRE);
		List<Pile> piles = new ArrayList<>();
		piles.add(new Pile(Bouton.NOIRE));
		piles.add(pile);
		Plateau plateau = new Plateau(piles);
		Jeu jeu = new Jeu(plateau, new Joueur("Bastien", Bouton.ROUGE), new Joueur("Claudy", Bouton.NOIRE));
		assertTrue(jeu.regleCouleur(jeu.getPlateau().getFirst(), 1));
	}
	
	@Test
	public void testRegleCouleur2(){
		Pile pile1 = new Pile(Bouton.ROUGE);
		Pile pile2 = new Pile(Bouton.NOIRE);
		Pile p3 = new Pile(Bouton.ROUGE);
		Pile p4 = new Pile(Bouton.NOIRE);
		List<Pile> piles = new ArrayList<>();
		piles.add(pile1);
		piles.add(pile2);
		piles.add(p3);
		piles.add(p4);
		Plateau plateau = new Plateau(piles);
		Jeu jeu = new Jeu(plateau, new Joueur("Bastien", Bouton.ROUGE), 
						new Joueur("Claudy", Bouton.NOIRE));
		assertTrue(jeu.regleCouleur(jeu.getPlateau().getFirst(), 2));
		assertFalse(jeu.regleCouleur(jeu.getPlateau().getFirst(), 3));
	}
	
	@Test
	public void testAppliquerRegle(){
		Pile pile = new Pile(Bouton.NOIRE);
		List<Pile> piles = new ArrayList<>();
		piles.add(new Pile(Bouton.NOIRE));
		piles.add(pile);
		Plateau plateau = new Plateau(piles);
		Jeu jeu = new Jeu(plateau, new Joueur("Bastien", Bouton.ROUGE), new Joueur("Claudy", Bouton.NOIRE));
		assertTrue(jeu.appliquerRegle(jeu.getPlateau().getFirst(), 1));
		
		pile.add(Bouton.BLANC);
		assertFalse(jeu.appliquerRegle(jeu.getPlateau().getFirst(), 1));
	}
	
	@Test
	public void testSemer1() throws ButupException{
		Pile p1 = jeu.getPile(0);
		Pile p2 = jeu.getPile(1);
		Pile p3 = new Pile();
		p3.addAll(p2);
		p3.addAll(p1);
		jeu.semer(1,2);
		Pile nouvelle_p2 = jeu.getPile(0);
		assertEquals(p3, nouvelle_p2);
	}
	
	@Test
	public void testSemer2() throws ButupException {
		Pile p1 = new Pile(Bouton.ROUGE);
		Pile p2 = new Pile(Bouton.NOIRE);
		List<Pile> piles = new ArrayList<>();
		piles.add(p1);
		piles.add(p2);
		Plateau plateau = new Plateau(piles);
		Jeu jeu = new Jeu(plateau, new Joueur("Bastien", Bouton.ROUGE), new Joueur("Claudy", Bouton.NOIRE));
		assertFalse(jeu.semer(1, 2));
	}
	
	@Test
	public void testSetScoresJoueurs(){
		Pile p1 = new Pile(Bouton.ROUGE);
		p1.add(Bouton.NOIRE);
		p1.add(Bouton.ROUGE);
		List<Pile> piles = new ArrayList<>();
		piles.add(p1);
		Jeu jeu = new Jeu(new Plateau(piles), new Joueur("Bastien", Bouton.NOIRE), new Joueur("Claudy", Bouton.ROUGE));
		jeu.setScoresJoueurs();
		int scoreJoueur1 = 0;
		int scoreJoueur2 = 4;
		assertEquals(scoreJoueur1, jeu.getJoueur1().getScore());
		assertEquals(scoreJoueur2, jeu.getJoueur2().getScore());
	}
	
	@Test
	public void testFinPartie(){
		Joueur j1 = new Joueur("Bastien", Bouton.ROUGE);
		Joueur j2 = new Joueur("Claudy", Bouton.NOIRE);
		j1.setScore(10);
		j2.setScore(16);
		Jeu jeu = new Jeu(new Plateau(), j1, j2);
		assertTrue(jeu.finPartie());
		j2.setScore(10);
		assertFalse(jeu.finPartie());
	}
	@Test
	public void testChangerJoueurCourant(){
		assertTrue(jeu.getJoueur1().isCourant());
		assertFalse(jeu.getJoueur2().isCourant());
		
		jeu.changerJoueurCourant();
		assertFalse(jeu.getJoueur1().isCourant());
		assertTrue(jeu.getJoueur2().isCourant());
		
	}
}
