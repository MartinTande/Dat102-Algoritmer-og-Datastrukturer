package oppgave1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class JavaSetToMengde<T> implements MengdeADT<T> {
	
	
	private Set<T> set = new HashSet<>();


	@Override
	public boolean erTom() {
		return set.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		return set.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for(T element : set) {
			if (!annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		this.erDelmengdeAv(annenMengde);
		if (annenMengde.antallElementer() != set.size()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for(T element : set) {
			if (annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snittSet = new JavaSetToMengde<>();
		
		for(T element : set) {
			if (annenMengde.inneholder(element)) {
				snittSet.leggTil(element);
			}
		}
		return (MengdeADT<T>) snittSet;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> unionSet = new JavaSetToMengde<>();
		unionSet.leggTilAlleFra(annenMengde);
		unionSet.leggTilAlleFra(this);
		return (MengdeADT<T>) unionSet;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minusSet = new JavaSetToMengde<>();
		
		for(T element : set) {
			if (!annenMengde.inneholder(element)) {
				minusSet.leggTil(element);
			}
		}
		return minusSet;
	}

	@Override
	public void leggTil(T element) {
		set.add(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		T[] annenTabell = annenMengde.tilTabell();
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			set.add(annenTabell[i]);
		}
	}

	@Override
	public T fjern(T element) {
		boolean removed = set.remove(element);
		return removed ? element : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
		return (T[]) set.toArray();
	}

	@Override
	public int antallElementer() {
		return set.size();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
