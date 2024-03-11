package oppgave1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MengdeTabellTest {
	
	MengdeADT<Integer> intMengde1 = new MengdeTabell<>(4);
	MengdeADT<Integer> intMengde2 = new MengdeTabell<>(4);
	MengdeADT<Integer> tomMengde = new MengdeTabell<>(4);
	
	
	@BeforeEach
	void setUp() throws Exception {
		intMengde1.leggTil(1);
		intMengde1.leggTil(2);
		intMengde1.leggTil(3);
		intMengde1.leggTil(4);
//		
//		intMengde2.leggTil(3);
//		intMengde2.leggTil(4);
//		intMengde2.leggTil(5);
//		intMengde2.leggTil(6);		
	}

	@Test
	void testErTom() {
		assertTrue(tomMengde.erTom());
		assertFalse(intMengde1.erTom());
	}
	
	@Test
	void testLeggTil() {
		tomMengde.leggTil(5);
		assertEquals(1, tomMengde.antallElementer());
		intMengde1.leggTil(5);
		assertEquals(5, intMengde1.antallElementer());
	}
	
	@Test
	void testFjern() {
		tomMengde.fjern(5);
		
	}

}
