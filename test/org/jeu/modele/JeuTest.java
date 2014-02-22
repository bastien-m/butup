package org.jeu.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.jeu.metier.Jeu;
import org.jeu.modele.Pile.Bouton;
import org.junit.Before;
import org.junit.Test;

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

}
