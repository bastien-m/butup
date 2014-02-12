package org.jeu;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testDepiler(){
		List<Pile.Bouton> l = new ArrayList<>();
		l.add(Pile.Bouton.NOIRE);
		l.add(Pile.Bouton.ROUGE);
		Pile p0 = new Pile(l);
		Pile.Bouton bouton = p0.depiler();
		assertEquals(bouton, Pile.Bouton.ROUGE);
	}
	
}
