package oppgave2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RekursjonTest {

	@Test
	void sjekkIsPalindrone() {
		assertTrue(Rekursjon.isPalindrome("anna"));
		assertFalse(Rekursjon.isPalindrome("Nils"));
		assertTrue(Rekursjon.isPalindrome("regninger"));
	}


}
