package oppgave1;

import java.util.Collection;
import java.util.HashSet;
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

	@SuppressWarnings("unchecked")
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		Set<T> snittSet = new HashSet<>();
		
		for(T element : set) {
			if (annenMengde.inneholder(element)) {
				snittSet.add(element);
			}
		}

		return (MengdeADT<T>) snittSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		Set<T> unionSet = new HashSet<>();
		unionSet.addAll((Collection<? extends T>) annenMengde);
		unionSet.addAll((Collection<? extends T>) set);
		return (MengdeADT<T>) unionSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		Set<T> minusSet = new HashSet<>();
		
		for(T element : set) {
			if (!annenMengde.inneholder(element)) {
				minusSet.add(element);
			}
		}

		return (MengdeADT<T>) minusSet;
	}

	@Override
	public void leggTil(T element) {
		set.add(element);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		set.addAll((Collection<? extends T>) annenMengde);
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

}
