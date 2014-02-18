package org.jeu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PileTest {

	private Pile p0, p1, p2;
	
	@Before
	public void setUp(){
		List<Pile.Bouton> liste_boutons0 = new ArrayList<>();
		liste_boutons0.add(Pile.Bouton.NOIRE);
		liste_boutons0.add(Pile.Bouton.ROUGE);
		liste_boutons0.add(Pile.Bouton.BLANC);
		
		p0 = new Pile(liste_boutons0);

		List<Pile.Bouton> liste_boutons1 = new ArrayList<>();
		liste_boutons1.add(Pile.Bouton.ROUGE);
		liste_boutons1.add(Pile.Bouton.BLANC);
		liste_boutons1.add(Pile.Bouton.NOIRE);
		
		p1 = new Pile(liste_boutons1);
		
		List<Pile.Bouton> liste_boutons2 = new ArrayList<>();
		liste_boutons2.add(Pile.Bouton.ROUGE);
		liste_boutons2.add(Pile.Bouton.NOIRE);
		
		p2 = new Pile(liste_boutons2);
		
		
	}
	
	
	@Test
	public void testCreationPile() {
		Pile p = new Pile(Pile.Bouton.NOIRE);
		String effectif = p.toString();
		String attendu = "[NOIRE]";
		assertEquals(attendu,effectif);
	}

	@Test
	public void testEmpiler(){
		p0.empiler(p1);
		String effectif = p0.toString();
		assertEquals("[NOIRE, ROUGE, BLANC, ROUGE, BLANC, NOIRE]",effectif );
	}
	
	@Test
	public void testDepiler(){
		Pile.Bouton bouton = p0.depiler();
		assertEquals(Pile.Bouton.BLANC,bouton);
		assertEquals("[NOIRE, ROUGE]",p0.toString());
	}
	
	@Test
	public void testJouable(){
		assertFalse(p2.pileJouable());
	}
	
	
	@Test
	public void testVide(){
		assertFalse(p2.estVide());
	}
	
	@Test
	public void testEmpilerBouton(){
		p1.empiler(p2.depiler());
		assertEquals("[ROUGE, BLANC, NOIRE, NOIRE]", p1.toString());
		assertEquals("[ROUGE]", p2.toString());
	}
}
