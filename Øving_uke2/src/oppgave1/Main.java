package oppgave1;

public class Main {
	static void skrivTab(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
		System.out.print(tab[i] + " ");
		}
		System.out.println();
		}
		public static void main(String[] args) {
		int[] hTab = {1, 2, 3, 4};
		skrivTab(hTab);
		
		// a) Hva blir skrevet ut?
		for (int i = 0; i < hTab.length; i++) {
		hTab[i]++;
		}
		skrivTab(hTab);
		
		// b) Hva blir skrevet ut?
		for (int t : hTab) {
		t++;
		}
		skrivTab(hTab);
		Heltall[] rTab = new Heltall[4];
		rTab[0] = new Heltall(1);
		rTab[1] = new Heltall(2);
		rTab[2] = new Heltall(3);
		rTab[3] = new Heltall(4);
		
		// c) Hvorfor fungerer ikke denne?
		// skrivTab(rTab);
		
		// d) Hva blir skrevet ut?
		for (Heltall t : rTab) {
		System.out.print(t + " ");
		}
		System.out.println();
		
		// e) Hva blir skrevet ut?
		for (Heltall t : rTab) {
		t.inkrementer();
		}
		for (Heltall t : rTab) {
		System.out.print(t + " ");
		}
		System.out.println();
	}
}

