package oppgave1;

import java.util.Random;

public class SortMain {

	public static void main(String[] args) {		
		
		int n = 40_001;
		int antall = 10;
		
		Integer[][] a = genererRandomTabell(antall, n);
		Integer[][] b = genererRandomTabell(antall, n);
		taTidPaaFunksjon1(a, antall, n);
		taTidPaaFunksjon2(b, antall, n);
	}
	
	public static void taTidPaaFunksjon1(Integer[][] a, int antall, int n) {
		// Sorteringsalgoritme 1
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			a[i] = SortArray.insertionSort(a[i]); // a[i] blir en eindimensjonal tabell
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = (stopTime - startTime)/antall;
		System.out.println("Sorteringsalgoritme 1 tok " + elapsedTime + "ms");
	}
	
	public static void taTidPaaFunksjon2(Integer[][] a, int antall, int n) {
		// Sorteringsalgoritme 2
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < antall; i++){
			a[i] = SortArray.insertionSort3(a[i]); // a[i] blir en eindimensjonal tabell
		}
		long stopTime2 = System.currentTimeMillis();
		long elapsedTime2 = (stopTime2 - startTime2)/antall;
		System.out.println("Sorteringsalgoritme 3 tok: " + elapsedTime2 + "ms");
	}
	
	
	public static Integer[][] genererRandomTabell(int antall, int n) {
		// setter inn tilfeldige heltall i alle rekker
		Random tilfeldig = new Random();
		Integer[][] a = new Integer[antall][n];
		for (int i = 0; i < antall; i++){
			for (int j = 0; j < n; j++){
				a[i][j] = tilfeldig.nextInt();
			}
		}
		return a;
	}
}
