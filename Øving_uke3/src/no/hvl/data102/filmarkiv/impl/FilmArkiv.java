package no.hvl.data102.filmarkiv.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import no.hvl.data102.filmarkiv.adt.FilmArkivADT;


public class FilmArkiv implements FilmArkivADT{
	
	private Film[] tabell;
	private int antall;
	
	public FilmArkiv(int filmKapasitet) {
		tabell = new Film[filmKapasitet];
		antall = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		for (Film film : tabell) {
			if (film.getFilmNr() == nr) {
				return film;
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == tabell.length) {
			utvidTabell();
		}
		tabell[antall] = nyFilm;
		antall++;		
	}
	
	@Override
	public boolean slettFilm(int filmNr) {
		for (Film film : tabell) {
			if (film.getFilmNr() == filmNr) {
				tabell[filmNr] = tabell[tabell.length-1];
				antall--;
				return true;
			}
		}
		return false;
	}	
	
	private void utvidTabell() {
		tabell = Arrays.copyOf(tabell, tabell.length * 2);
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tabellTittelSoek = new Film[tabell.length];
		int i = 0;
		for (Film film : tabell) {
			if (film.getTittel().contains(delstreng)) {
				tabellTittelSoek[i] = film;
				i++;
			}
		}
		return tabellTittelSoek;
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tabellProdusentSoek = new Film[tabell.length];
		int i = 0;
		for (Film film : tabell) {
			if (film.getProdusent().contains(delstreng)) {
				tabellProdusentSoek[i] = film;
				i++;
			}
		}
		return tabellProdusentSoek;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		for (Film film : tabell) {
			if (film.sjanger == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}



}
