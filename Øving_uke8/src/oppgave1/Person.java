package oppgave1;

public class Person {

	private String navn;
	private MengdeADT<String> hobbyer;
	
	public Person(String navn, String... hobbyer) {
		this.navn = navn;
        this.hobbyer = new TabellMengde<>();
        for (String hobby : hobbyer) {
            this.hobbyer.leggTil(hobby);
        }
	}
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<String> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<String> hobbyer) {
		this.hobbyer = hobbyer;
	}
}
