package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.FilmArkiv;

class FilmArkivTest {
	
	FilmArkiv tomtFilmArkiv;
	FilmArkiv filmArkiv;
	
	@BeforeEach
	void oppsettSomGjenbrukesIHverTest() {
		
		tomtFilmArkiv = new FilmArkiv(0);
		
		Film film1 = new Film(1, "Marvel", "Avengers", 2012, "Warner Brothers");
		filmArkiv = new FilmArkiv(1);
		filmArkiv.leggTilFilm(film1);
	}
	
	@Test
	void testAntall() {
		assertEquals(0, tomtFilmArkiv.antall());
		assertEquals(1, filmArkiv.antall());
	}
	
	@Test
	void testLeggTilFilm() {
		Film film = new Film();
		tomtFilmArkiv.leggTilFilm(film);
		
	}

}
