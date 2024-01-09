package oppgave2;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Rektangel rektangel = new Rektangel(2, 3);
//		rektangel.tegn();
		
		Trekant trekant = new Trekant(5);
//		trekant.tegn();
		
		List<Figur> figurListe = new ArrayList<>();
		
		figurListe.add(trekant);
		figurListe.add(rektangel);
		
		double totalAreal = 0;
		for (Figur figur : figurListe) {
			System.out.println("Areal: " + figur.areal());
			totalAreal += figur.areal();
		}
		System.out.println("Total areal: " + totalAreal);
		
		for (Figur figur : figurListe) {
			figur.tegn();
			System.out.println();
		}
		
	}
}
