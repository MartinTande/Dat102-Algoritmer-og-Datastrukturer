package oppgave1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MengdeTabellTest {
	
	MengdeADT<Integer> intMengde1;
	MengdeADT<Integer> intMengde2;
	MengdeADT<Integer> intMengde3;
	MengdeADT<Integer> tomMengde;
	MengdeADT<Integer> tomMengde2;
	MengdeADT<Integer> delMengde;
	
	@BeforeEach
	void setUp() throws Exception {

		intMengde1 = new JavaSetToMengde<>();
		intMengde2 = new JavaSetToMengde<>();
		intMengde3 = new JavaSetToMengde<>();
		tomMengde = new JavaSetToMengde<>();
		tomMengde2 = new JavaSetToMengde<>();
		delMengde = new JavaSetToMengde<>();
		
		intMengde1.leggTil(1);
		intMengde1.leggTil(2);
		intMengde1.leggTil(3);
		intMengde1.leggTil(4);
				
		delMengde.leggTil(1);
		delMengde.leggTil(2);
		
		intMengde2.leggTil(3);
		intMengde2.leggTil(4);
		intMengde2.leggTil(5);
		intMengde2.leggTil(6);		
		
		intMengde3.leggTil(1);
		intMengde3.leggTil(2);
		intMengde3.leggTil(3);
		intMengde3.leggTil(4);
	}

	@Test
	void testErTom() {
		assertTrue(tomMengde.erTom());
		assertFalse(intMengde1.erTom());
	}
	
	@Test
	void testAntallElementer() {
		assertEquals(0, tomMengde.antallElementer());
		assertEquals(4, intMengde1.antallElementer());
	}
	
	@Test
	void testLeggTil() {
		tomMengde.leggTil(5);
		assertEquals(1, tomMengde.antallElementer());
		intMengde1.leggTil(5);
		assertEquals(5, intMengde1.antallElementer());
		intMengde1.leggTil(5);
		assertEquals(5, intMengde1.antallElementer());
	}
	
	@Test
	void testLeggTilAlleFra() {
		tomMengde.leggTilAlleFra(intMengde1);
		assertEquals(intMengde1.antallElementer(), tomMengde.antallElementer());
		assertTrue(intMengde1.erLik(tomMengde));
	}
	
	@Test
	void testFjern() {
		assertEquals(null, tomMengde.fjern(5));
		assertEquals(4, intMengde1.fjern(4));
		assertEquals(null, intMengde1.fjern(4));
	}

	@Test
	void testInneholder() {
		assertFalse(tomMengde.inneholder(5));
		assertTrue(intMengde1.inneholder(4));
	}
	
	@Test
	void testErDelmengdeAv() {
		assertTrue(delMengde.erDelmengdeAv(intMengde1));
		assertFalse(intMengde1.erDelmengdeAv(delMengde));
	}
	
	@Test
	void testErLik() {
		assertFalse(delMengde.erLik(intMengde1));
		assertEquals(intMengde1.antallElementer(), intMengde3.antallElementer());
		assertTrue(intMengde1.erLik(intMengde3));
	}
	
	@Test
	void testErDisjunkte() {
		assertTrue(delMengde.erDisjunkt(intMengde2));
		assertFalse(delMengde.erDisjunkt(intMengde1));
	}
	
	@Test
	void testSnitt() {
		tomMengde.leggTil(1);
		tomMengde.leggTil(2);
		delMengde.leggTil(6);
		
		assertTrue(tomMengde.erLik(delMengde.snitt(intMengde1)));
		assertFalse(tomMengde.erLik(delMengde.snitt(intMengde2)));
	}
	
	@Test
	void testUnion() {
		tomMengde = intMengde1.union(intMengde2);
		tomMengde2.leggTilAlleFra(intMengde1);
		tomMengde2.leggTilAlleFra(intMengde2);
		assertTrue(tomMengde.erLik(tomMengde2));
	}

	@Test
	void testMinus() {
		tomMengde.leggTil(1);
		tomMengde.leggTil(2);
		assertTrue(tomMengde.erLik(intMengde1.minus(intMengde2)));
	}
}
