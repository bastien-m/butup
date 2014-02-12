package org.jeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateauTest {

	@Test
	public void testToString() {
		Plateau p = new Plateau();
		String attendu = "[[NOIRE], [ROUGE], [BLANC], [NOIRE], [ROUGE], [BLANC], [NOIRE], [ROUGE], [BLANC]]";
		assertEquals(p.toString(), attendu);
	}
	
	

}
