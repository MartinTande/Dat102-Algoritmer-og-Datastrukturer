package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv implements FilmarkivADT{
	
	private Film[] tabell;
	private int antall;
	
	public Filmarkiv(int filmKapasitet) {
		tabell = new Film[filmKapasitet];
		antall = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i < antall; i++) {
			if (tabell[i].getFilmNr() == nr) {
				return tabell[i];
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
		for (int i = 0; i < antall; i++) {
			if (tabell[i].getFilmNr() == filmNr) {
				tabell[i] = tabell[antall-1];
				tabell[antall-1] = null;
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
		Film[] tabellTittelSoek = new Film[antall];
		int n = 0;
		for (int i = 0; i < antall; i++) {
			if (tabell[i].getTittel().contains(delstreng)) {
				tabellTittelSoek[n] = tabell[i];
				n++;
			}
		}
		return trimTab(tabellTittelSoek, n);
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tabellProdusentSoek = new Film[antall];
		int n = 0;
		for (int i = 0; i < antall; i++) {
			if (tabell[i].getProdusent().contains(delstreng)) {
				tabellProdusentSoek[n] = tabell[i];
				n++;
			}
		}
		return trimTab(tabellProdusentSoek, n);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (tabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer i ny tabell
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
}
