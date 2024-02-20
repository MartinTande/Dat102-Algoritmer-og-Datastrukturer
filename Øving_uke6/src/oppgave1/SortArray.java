package oppgave1;

public class SortArray {
	
	public static <T extends Comparable<? super T>> T[] insertionSort(T[] a) {
		for (int i = 1; i < a.length; i++) {
			T temp = a[i];
			int j = i - 1;
			
			while (j >= 0 && a[j].compareTo(temp) > 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
		return a;
	}
	
	public static <T extends Comparable<? super T>> T[] insertionSort2(T[] a) {
		moveSmallestToFront(a);
		
		// begynn sortering
		for (int i = 2; i < a.length; i++) {
			T temp = a[i];
			int j = i - 1;
			
			// finn rett plass
			while (j >= 1 && a[j].compareTo(temp) > 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
		return a;
	}
	
	public static <T extends Comparable<? super T>> T[] insertionSort3(T[] a) {
		moveSmallestToFront(a);

		// begynn sortering
		for (int i = 3; i < a.length; i+= 2) {
			T storste;
			T minste;	
			
			if (a[i].compareTo(a[i + 1]) <= 0) {
				minste = a[i];
				storste = a[i + 1];
			}else {
				storste = a[i];
				minste = a[i + 1];
			}

			int j = i - 1;
			
			// finn rett plass
			while (j >= 1 && storste.compareTo(a[j]) < 0 && a.length % 2 != 0) {
				a[j + 2] = a[j];
				j--;
			}
			a[j + 2] = storste;

			while (j >= 1 && minste.compareTo(a[j]) < 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = minste;
		}
		return a;
	}

	private static <T extends Comparable<? super T>> void moveSmallestToFront(T[] a) {
		// finn minste element og plasser det først i tabellen før sortering begynner
		T smallest = a[0];
		int smallestIndex = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (smallest.compareTo(a[i+1]) > 0) {
				smallest = a[i+1];
				smallestIndex = i+1;
			}
		}
		T tempSmall = a[0];
		a[0] = smallest;
		a[smallestIndex] = tempSmall;
	}
	

	
}
