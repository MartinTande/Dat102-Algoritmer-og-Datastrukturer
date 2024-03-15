package oppgave1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LenketMengde<T> implements MengdeADT<T>{

	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}
	
	/************************************************************/

	private Node forste;
	private int antall;
	
	public LenketMengde() {
		forste = null;
		antall = 0;
	}
	
	/************************************************************/

	/* ------------------------------------------------------------------- */

	private class LenketMengdeIterator implements Iterator<T> {
		
		Node nesteNode = forste;
		
		@Override
		public boolean hasNext() {
			return nesteNode != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException(
						"Ulovlig å kalle next() hvis iterator.!hasNext().");
			}
			T data = nesteNode.data;
			nesteNode = nesteNode.neste;
			return data;
		}
	}
	
	/* ------------------------------------------------------------------- */

	@Override
	public Iterator<T> iterator() {
		return new LenketMengdeIterator();
	}

	/* ------------------------------------------------------------------- */
	
	
	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T entry) {
		Node temp = forste;
		while(temp != null) {
			if (temp.data.equals(entry)) {
				return true;
			}
			temp = temp.neste;
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		Node temp = forste;
		while(temp != null) {
			if (!annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
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
		Node temp = forste;
		while(temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snittMengde = new LenketMengde<>();
		Node temp = forste;
		while(temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				snittMengde.leggTil(temp.data);
			}
			temp = temp.neste;
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> unionMengde = new LenketMengde<>();
		unionMengde.leggTilAlleFra(annenMengde);
		unionMengde.leggTilAlleFra(this);

		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minusMengde = new LenketMengde<>();
		Node temp = forste;
		while(temp != null) {
			if (!annenMengde.inneholder(temp.data)) {
				minusMengde.leggTil(temp.data);
			}
			temp = temp.neste;
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		if (inneholder(element)) {
			return;
		}
		Node ny = new Node(element);
		ny.neste = forste;
		forste = ny;
		antall++;	
	}
	
	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for(T element : annenMengde) {
			if (!inneholder(element)) {
				leggTil(element);
			}
		}
	}

	@Override
	public T fjern(T entry) {
		Node temp = forste;
		while(temp != null) {
			if (temp.data == entry) {
				temp = forste;
				forste = null;
				antall--;
				return entry;
			}
			temp = temp.neste;
		}
		return null;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] resultat = (T[]) new Object[antall];

		return resultat;
	}

	@Override
	public int antallElementer() {
		return antall;
	}
	
}
