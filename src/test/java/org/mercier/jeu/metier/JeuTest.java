package org.mercier.jeu.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
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
		int indiceATester = 5;
		Pile courante = jeu.avancerCurseur(indiceATester);
		assertEquals(courante, jeu.getPile(indiceATester));		
	}
}
