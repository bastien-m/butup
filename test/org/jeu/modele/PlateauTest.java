package org.jeu.modele;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jeu.modele.Pile;
import org.jeu.modele.Plateau;
import org.jeu.modele.Pile.Bouton;
import org.junit.Before;
import org.junit.Test;


public class PlateauTest {

	private Plateau p;
	
	@Before
	public void setUp(){
		List<Pile> piles = new ArrayList<>();
		Pile pile0 = new Pile(Bouton.ROUGE);
		Pile pile1 = new Pile(Bouton.NOIRE);
		piles.add(pile0);
		piles.add(pile1);
		p = new Plateau(piles);
	}
	
	@Test
	public void testSuivant(){
		Pile p0 = p.suivant();
		Iterator<Pile> it = p.iterator();
		assertEquals(it.next(), p0);
		p0 = p.suivant();
		assertEquals(it.next(), p0);
		it = null;
		p0 = p.suivant();
		assertEquals(p.getFirst(), p0);
	}
}
