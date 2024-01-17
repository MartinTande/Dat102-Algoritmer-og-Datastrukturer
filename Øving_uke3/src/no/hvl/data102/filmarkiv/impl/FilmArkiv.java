package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmArkivADT;
import no.hvl.data102.filmarkiv.adt.Sjanger;

public class FilmArkiv implements FilmArkivADT{
	
	private Film[] tabell;
	private int antall;
	
	public FilmArkiv(int filmKapasitet) {
		tabell = new Film[filmKapasitet];
		antall = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		// TODO Auto-generated method stub
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
	
	private void utvidTabell() {
		tabell = Arrays.copyOf(tabell, tabell.length * 2);
	}
	
	@Override
	public boolean slettFilm(int filmNr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

}
