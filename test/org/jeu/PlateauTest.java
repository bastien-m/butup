package org.jeu;

import static org.junit.Assert.assertEquals;

import org.jeu.exception.ButupException;
import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	private Plateau p;
	
	@Before
	public void setUp(){
		p = new Plateau();
	}
	
	@Test
	public void testToString() {
		String attendu = "[[NOIRE], [ROUGE], [BLANC], [NOIRE], [ROUGE], [BLANC], [NOIRE], [ROUGE], [BLANC]]";
		assertEquals(p.toString(), attendu);
	}

	@Test
	public void testRecupererPile() throws ButupException{
		Pile pile = p.recupererPile(9);
		assertEquals("[BLANC]", pile.toString());
	}

	@Test
	public void testSemer() throws ButupException{
		p.semer(1, 2);
		Pile pile1 = p.recupererPile(1);
		assertEquals("[ROUGE, NOIRE]", pile1.toString());
		p.semer(1, 2);
		pile1 = p.recupererPile(1);
		assertEquals("[BLANC, NOIRE]", pile1.toString());
		p.semer(1, 2);
		pile1 = p.recupererPile(1);
		Pile pile2 = p.recupererPile(2);
		assertEquals("[NOIRE, ROUGE, NOIRE]", pile1.toString());
		assertEquals("[ROUGE, BLANC]", pile2.toString());
	}
	
	@Test
	public void testCalculPointRouge(){
		
	}
	
	@Test
	public void testCalculPointNoire(){
		
	}
	
}
