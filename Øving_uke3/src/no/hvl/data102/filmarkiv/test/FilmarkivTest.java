package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
	
	FilmarkivADT tomtFilmArkiv;
	FilmarkivADT filmArkiv;
	
	@BeforeEach
	void oppsettSomGjenbrukesIHverTest() {
		// Kjøres for å teste FilmArkiv classen
//		tomtFilmArkiv = new Filmarkiv(10);
//		filmArkiv = new Filmarkiv(10);	
		
		//Kjøres for å teste FilmArkiv2 klassen
		tomtFilmArkiv = new Filmarkiv2();
		filmArkiv = new Filmarkiv2();	
		
		Film film1 = new Film(1, "Joss Whedon", "The Avengers", 2012, "Marvel Studios", Sjanger.ACTION);
		Film film2 = new Film(2, "Christopher Nolan", "Batman Begins", 2008, "Warner Brothers", Sjanger.ACTION);
		Film film3 = new Film(3, "Morten Tyldum", "The Imitation Game", 2014, "StudioCanal", Sjanger.DRAMA);

		filmArkiv.leggTilFilm(film1);
		filmArkiv.leggTilFilm(film2);
		filmArkiv.leggTilFilm(film3);
	}
	
	@Test
	void testAntall() {
		assertEquals(0, tomtFilmArkiv.antall());
		assertEquals(3, filmArkiv.antall());
	}
	
	@Test
	void testLeggTilFilm() {
		assertEquals(0, tomtFilmArkiv.antall());
		Film film1 = new Film(1, "Joss Whedon", "The Avengers", 2012, "Marvel Studios", Sjanger.ACTION);
		tomtFilmArkiv.leggTilFilm(film1);
		assertEquals(1, tomtFilmArkiv.antall());
	}
	
	@Test
	void testFinnFilm() {
		Film film = new Film(2, "Christopher Nolan", "Batman Begins", 2008, "Warner Brothers", Sjanger.ACTION);
		assertEquals(film, filmArkiv.finnFilm(2));
	}

	@Test
	void testLeggTilFilmOgUtivdTabell() {
		Film film4 = new Film(4, "Christpher Nolan", "Interstellar", 2014, "Paramount Pictures", Sjanger.DRAMA);
		filmArkiv.leggTilFilm(film4);
		assertEquals(4, filmArkiv.antall());
	}
	
	@Test
	void testSlettFilm() {
		assertTrue(filmArkiv.slettFilm(1));
		assertFalse(filmArkiv.slettFilm(10));
	}
	
	@Test
	void testSoekTittel() {
		Film film1 = new Film(1, "Joss Whedon", "The Avengers", 2012, "Marvel Studios", Sjanger.ACTION);
		Film film2 = new Film(2, "Christopher Nolan", "Batman Begins", 2008, "Warner Brothers", Sjanger.ACTION);
		Film[] filmListe = filmArkiv.soekTittel("Batman Begins");
		assertEquals(film2, filmListe[0]);
		assertNotEquals(film1, filmListe[0]);
	}
	
	@Test
	void testSoekProdusent() {
		Film film1 = new Film(1, "Joss Whedon", "The Avengers", 2012, "Marvel Studios", Sjanger.ACTION);
		Film film2 = new Film(2, "Christopher Nolan", "Batman Begins", 2008, "Warner Brothers", Sjanger.ACTION);
		Film[] filmListe = filmArkiv.soekProdusent("Christopher Nolan");
		assertEquals(film2, filmListe[0]);
		assertNotEquals(film1, filmListe[0]);
	}
	
	@Test
	void testAntallSjanger() {
		assertEquals(2, filmArkiv.antall(Sjanger.ACTION));
		assertEquals(1, filmArkiv.antall(Sjanger.DRAMA));
		assertEquals(0, filmArkiv.antall(Sjanger.SCIFI));
		assertEquals(0, filmArkiv.antall(Sjanger.HISTORY));
	}
	
}
