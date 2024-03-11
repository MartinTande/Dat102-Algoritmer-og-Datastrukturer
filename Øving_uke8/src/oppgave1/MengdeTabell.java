package oppgave1;

import java.util.Arrays;

public class MengdeTabell<T> implements MengdeADT<T>{

	private static final int DEFAULT_CAPACITY = 10;
	
	private T[] tabell;
	private int antall;
	
	public MengdeTabell() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MengdeTabell(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
		antall = 0;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tabell);
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
		MengdeTabell other = (MengdeTabell) obj;
		return Arrays.deepEquals(tabell, other.tabell);
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
		for (T element : tabell) {
			if (!annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		T[] annenTabell = annenMengde.tilTabell();
		for (T element : annenTabell) {
			if (!annenMengde.inneholder(element)) {
				return false;
			}
		}
		if (annenMengde.antallElementer() == antall) {
			return false;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (T element : tabell) {
			if (annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snittMengde = new MengdeTabell<>();
		T[] annenTabell = annenMengde.tilTabell();
		
		for (T element : tabell) {
			if (!annenMengde.inneholder(element)) {
				snittMengde.leggTil(element);
			}
		}
		for (T element : annenTabell) {
			if (!annenMengde.inneholder(element)) {
				snittMengde.leggTil(element);
			}
		}

		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> unionMengde = new MengdeTabell<>();
		unionMengde.leggTilAlleFra(annenMengde);
		
		for (T element : tabell) {
			if (!annenMengde.inneholder(element)) {
				unionMengde.leggTil(element);
			}
		}

		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minusMengde = new MengdeTabell<>();
		
		for (T element : tabell) {
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
		for (T element : annenTabell) {
			leggTil(element);
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

}
