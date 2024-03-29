package oppgave1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class TabellMengde<T> implements MengdeADT<T>{

	/* ------------------------------------------------------------------- */

	private class TabellMengdeIterator implements Iterator<T> {
		
		private int nesteIndeks = 0;

		@Override
		public boolean hasNext() {
			return nesteIndeks < antall;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException(
						"Ulovlig å kalle next() hvis iterator.!hasNext().");
			}
			return tabell[nesteIndeks++];
		}
	}
	
	/* ------------------------------------------------------------------- */
	
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private T[] tabell;
	private int antall;
	
	public TabellMengde() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public TabellMengde(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
		antall = 0;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tabell);
		result = prime * result + Objects.hash(antall);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		TabellMengde<T> other = (TabellMengde<T>) obj;
		return antall == other.antall && Arrays.deepEquals(tabell, other.tabell);
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T entry) {
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (element.equals(entry)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (!annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		this.erDelmengdeAv(annenMengde);
		if (annenMengde.antallElementer() != antall) {
			return false;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snittMengde = new TabellMengde<>();
		
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (annenMengde.inneholder(element)) {
				snittMengde.leggTil(element);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> unionMengde = new TabellMengde<>();
		unionMengde.leggTilAlleFra(annenMengde);
		unionMengde.leggTilAlleFra(this);

		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minusMengde = new TabellMengde<>();
		
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (!annenMengde.inneholder(element)) {
				minusMengde.leggTil(element);
			}
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		if (inneholder(element)) {
			return;
		}
		if (antall == tabell.length) {
			tabell = Arrays.copyOf(tabell, tabell.length * 2);
		}
		tabell[antall] = element;
		antall++;		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		T[] annenTabell = annenMengde.tilTabell();
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			T element = annenTabell[i];
			if (!this.inneholder(element)) {
				leggTil(element);
			}
		}
	}

	@Override
	public T fjern(T entry) {
		int indeks = 0;
		boolean funnet = false;
		
		while  (indeks < antall && !funnet) {
			if (entry.equals(tabell[indeks])) {
				funnet = true;
			} else {
				indeks++;
			}
		}
		if (!funnet) {
			return null;
		}
		
		tabell[indeks] = tabell[antall-1];
		tabell[antall-1] = null;
		antall--;
		return entry;
	}

	@Override
	public T[] tilTabell() {
		return Arrays.copyOf(tabell, antall);
	}

	@Override
	public int antallElementer() {
		return antall;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellMengdeIterator();
	}

}
