package oppgave2;

import java.util.Random;

public class AlgorithmMain {

	public static void main(String[] args) {		
		
		int[] nListe = {32_000, 64_000, 128_000, 10_000_000};
		int antall = 10;
		System.out.println("Quick Sort");
		System.out.println("N	Antall målinger		Målt tid	Teoretisk tid");
		for (int n : nListe) {
			Integer[][] a = genererRandomTabell(antall, n);
			taTidPaaFunksjon(a, antall, n);
		}

	}
	
	public static void taTidPaaFunksjon(Integer[][] a, int antall, int n) {
		// Sorteringsalgoritme 1
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < antall; i++){
			SortAlgorithm.quickSort(a[i]); // a[i] blir ein eindimensjonal tabell
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = (stopTime - startTime)/antall;
		double c = 2.1087404053919016E-05;
		double teoreticalTime = c * n*Math.log10(n);
		System.out.println(n + "	" + antall + "		" + elapsedTime + "ms		" + teoreticalTime + "ms");
	}	
	
	public static Integer[][] genererRandomTabell(int antall, int n) {
		// set inn tilfeldige heiltal i alle rekker
		Random tilfeldig = new Random();
		Integer fastVariabel = 10;
		Integer[][] a = new Integer[antall][n];
		for (int i = 0; i < antall; i++){
			for (int j = 0; j < n; j++){
				a[i][j] = fastVariabel;
			}
		}
		return a;
	}

}
