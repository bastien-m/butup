package org.jeu;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JeuTest {

	private Jeu jeu; 
	
	@Before
	public void setUp(){
		Joueur j1 = new Joueur("Bastien", Pile.Bouton.ROUGE);
		Joueur j2 = new Joueur("Claudy", Pile.Bouton.ROUGE);
		
		jeu = new Jeu(j1,j2);
	}
	
	@Test
	public void testVerificationCouleur() {
		assertEquals(Pile.Bouton.NOIRE, jeu.getJoueur2().getCouleur());
	}

}
