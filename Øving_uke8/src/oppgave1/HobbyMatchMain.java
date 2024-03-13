package oppgave1;

public class HobbyMatchMain {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("Hans", "Fiske", "Klatre", "Dataspill", "Kyting", "Jodling");
		Person p2 = new Person("Grete", "Jakt", "Dykking", "Klatre", "venner", "trening");
		Person p3 = new Person("Olav", "Fiske", "Klatre", "Kyting", "Dataspill", "trening");
		
		System.out.println("p1 og p2: " + match(p1, p2));
		System.out.println("p2 og p1: " + match(p2, p1));
		System.out.println("p2 og p3: " + match(p1, p2));
		System.out.println("p1 og p3: " + match(p1, p3));
		System.out.println("p1 og p1: " + match(p1, p1));
	}
	
	
	static double match(Person a, Person b) {
		MengdeADT<String> aHobbyer = a.getHobbyer();
		MengdeADT<String> bHobbyer = b.getHobbyer();
		
		int antallFelles = aHobbyer.snitt(bHobbyer).antallElementer();
		int antallKunHosDenEne = aHobbyer.minus(bHobbyer).antallElementer();
		int antallKunHosDenAndre = bHobbyer.minus(aHobbyer).antallElementer();
		int antallTotalt = aHobbyer.union(bHobbyer).antallElementer();
				
		double match = antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt;
		return match;
	}
	
}
