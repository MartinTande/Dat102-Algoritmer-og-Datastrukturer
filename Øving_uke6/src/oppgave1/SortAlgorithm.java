package oppgave1;

public class SortAlgorithm {
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		for (int i = 1; i < a.length; i++) {
			T temp = a[i];
			int j = i - 1;
			
			while (j >= 0 && a[j].compareTo(temp) > 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
		for (int i = 0; i < a.length; i++) {
			T min = a[i];
			int minIndeks = i;
			
			for (int j = i+1; j < a.length; j++) {
				if (a[j].compareTo(min) < 0) {
					min = a[j];
					minIndeks = j;
				}
			}
			swap(a, i, minIndeks);
		}
	}
	
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
		mergeSort(a, 0, a.length - 1);
	}
	
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length];
		mergeSort(a, tempArray, first, last);
	}
	
	
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempTab, int forste, int siste) {
		
		if (forste >= siste) {
			// basis, gjør ingenting 
		} else {
			int midten = (forste + siste) / 2;
			mergeSort(a, forste, midten);
			mergeSort(a, midten + 1, siste);
			merge(a, tempTab, forste, midten, siste);
		}
		
	}
	
	public static <T extends Comparable<? super T>> void merge(T[] a, T[] tempTab, int forste, int midten, int siste) {
		int forsteV = forste;
		int sisteV = midten;
		int forsteH = midten + 1;
		int sisteH = siste;
		
		int index = forsteV;
		while ((forsteV <= sisteV) && (forsteH <= sisteH)) {
			if (a[forsteV].compareTo(a[forsteH]) < 0) {
				tempTab[index] = a[forsteV];
				forsteV++;
			} else {
				tempTab[index] = a[forsteH];
				forsteH++;
			}
			index++;
		}
		
		for (; forsteV <= sisteV; forsteV++, index++) {
			tempTab[index] = a[forsteV];
		}
		
		for (; forsteH <= sisteH; forsteH++, index++) {
			tempTab[index] = a[forsteH];
		}

		for (index = forste; index <= siste; index++) {
			a[index] = tempTab[index];
		}
	}
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a) {
		quickSort(a, 0, a.length - 1);
		insertionSort(a);
	}
	
	private static final int MIN_GRENSE = 5;
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a, int forste, int siste) {
		if (siste - forste + 1 < MIN_GRENSE) {
			// basistilfelle, gjør ingenting 
		} else {
			int delepunkt = partition(a, forste, siste);
			quickSort(a, forste, delepunkt - 1);
			quickSort(a, delepunkt + 1, siste);
		}
	}

	public static <T extends Comparable<? super T>> int partition(T[] a, int forste, int siste) {
		int midten = (forste + siste) / 2;
		
		sortFirstMiddleLast(a, forste, midten, siste);
		
		swap(a, midten, siste - 1);
		int pivotIndex = siste - 1;
		T pivotValue = a[pivotIndex];
		
		int fraVenstre = forste + 1;
		int fraHoyre = siste - 2;

		boolean ferdig = false;
		while (!ferdig) {

			while (a[fraVenstre].compareTo(pivotValue) < 0) {
				fraVenstre++;
			}

			while (a[fraHoyre].compareTo(pivotValue) > 0) {
				fraHoyre--;
			}

			if (fraVenstre < fraHoyre) {
				swap(a, fraVenstre, fraHoyre);
				fraVenstre++;
				fraHoyre--;
			} else {
				ferdig = true;
			}
		}

		swap(a, pivotIndex, fraVenstre);
		pivotIndex = fraVenstre;

		return pivotIndex;
	}

	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		order(a, first, mid); // Make a[first] <= a[mid]
		order(a, mid, last); // Make a[mid] <= a[last]
		order(a, first, mid); // Make a[first] <= a[mid]
	}

	private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
		if (a[i].compareTo(a[j]) > 0) {
			swap(a, i, j);
		}
	}
	
}






