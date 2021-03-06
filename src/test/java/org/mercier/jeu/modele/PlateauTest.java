package org.mercier.jeu.modele;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mercier.jeu.modele.Pile.Bouton;


public class PlateauTest {

	private Plateau p, p1;
	
	@Before
	public void setUp(){
		List<Pile> piles = new ArrayList<>();
		Pile pile0 = new Pile(Bouton.ROUGE);
		Pile pile1 = new Pile(Bouton.NOIRE);
		piles.add(pile0);
		piles.add(pile1);
		p = new Plateau(piles);
		p1 = new Plateau();
	}
	
	@Test
	public void creationPlateau(){
		Plateau plateau = new Plateau();
		assertEquals(9, plateau.size());
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
	
	@Test
	public void testPrecedent(){
		assertEquals(p.getLast(), p.precedent());
		assertEquals(p.getFirst(), p.precedent());
	}
	
	@Test
	public void testPlacerCurseur(){
		Pile pile = p1.placerCurseur(3);
		Pile pile4 = p1.get(3);
		assertEquals(pile4, pile);
	}
}
