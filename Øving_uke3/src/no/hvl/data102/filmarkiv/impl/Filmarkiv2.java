package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{
	
	private class LinearNode<T> {
		
		private T data;
		private LinearNode<T> neste;

		private LinearNode(T data) {
			this.data = data;
			this.neste = null;
		}
	}
	
	private LinearNode<Film> start;
	private int antall;
	
	public Filmarkiv2() {
		start = null;
		antall = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> temp = start;
		while(temp != null) {
			if (temp.data.getFilmNr() == nr) {
				return temp.data;
			}
			temp = temp.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> ny = new LinearNode<>(nyFilm);
		ny.neste = start;
		start = ny;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmNr) {
		LinearNode<Film> temp = start;
		while(temp != null) {
			if (temp.data.getFilmNr() == filmNr) {
				temp = start;
				start = null;
				antall--;
				return true;
			}
			temp = temp.neste;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> temp = start;
		Film[] tabellTittelSoek = new Film[antall];
		int i = 0;
		while(temp != null) {
			if (temp.data.getTittel().contains(delstreng)) {
				tabellTittelSoek[i] = temp.data;
				i++;
			}
			temp = temp.neste;
		}
		return trimTab(tabellTittelSoek, i);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> temp = start;
		Film[] tabellProdusentSoek = new Film[antall];
		int i = 0;
		while(temp != null) {
			if (temp.data.getProdusent().contains(delstreng)) {
				tabellProdusentSoek[i] = temp.data;
				i++;
			}
			temp = temp.neste;
		}
		return trimTab(tabellProdusentSoek, i);
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> temp = start;
		int antallSjanger = 0;
		while(temp != null) {
			if (temp.data.getSjanger() == sjanger) {
				antallSjanger++;
			}
			temp = temp.neste;
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] toArray() {
		Film[] resultat = (Film[]) new Object[antall];
		return resultat;
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
