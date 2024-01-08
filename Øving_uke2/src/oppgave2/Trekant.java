package oppgave2;

public class Trekant implements Figur{
	private double sideLengde;
	
	public Trekant(double sideLengde) {
		this.sideLengde = sideLengde;
	}

	public double areal() {
		// TODO Auto-generated method stub
		return sideLengde*sideLengde/2;
	}

	public void tegn() {
		for (int i = 0; i < sideLengde; i++) {
			System.out.print("*");
	
		}	
	}
	
	
}
