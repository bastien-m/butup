package org.jeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class PileTest {

	@Test
	public void testCreationPile() {
		Pile p = new Pile(Pile.Bouton.NOIRE);
		String effectif = p.toString();
		String attendu = "[NOIRE]";
		assertEquals(effectif, attendu);
	}

	@Test
	public void testEmpiler(){
		Pile p0 = new Pile(Pile.Bouton.NOIRE);
		Pile p1 = new Pile(Pile.Bouton.ROUGE);
		p0.empiler(p1);
		String effectif = p0.toString();
		assertEquals(effectif, "[NOIRE, ROUGE]");
	}
	
}
