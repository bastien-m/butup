package org.jeu.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ListIterator;

import org.jeu.modele.Pile.Bouton;
import org.junit.Before;
import org.junit.Test;

public class PileTest {

	private Pile p;
	
	@Before
	public void setUp(){
		p = new Pile();
		p.add(Bouton.ROUGE);
		p.add(Bouton.NOIRE);
		p.add(Bouton.BLANC);
	}
	
	@Test
	public void testAdd(){
		ListIterator<Bouton> lit = p.listIterator();
		assertEquals(Bouton.ROUGE,lit.next());
	}
	
	@Test
	public void testAdversaire(){
		ListIterator<Bouton> lit = p.listIterator();
		assertEquals(Bouton.NOIRE, lit.next().adversaire());
	}
	
	@Test
	public void testEquals(){
		Pile p0 = new Pile(Bouton.NOIRE);
		p0.offer(Bouton.ROUGE);
		Pile p1 = new Pile(Bouton.NOIRE);
		p1.offer(Bouton.ROUGE);
		
		assertTrue(p0.equals(p1));
	}
}
