package oppgave2;

public class Rektangel implements Figur{
	private double høyde;
	private double bredde;
	
	public Rektangel(double høyde, double bredde) {
		this.høyde = høyde;
		this.bredde = bredde;
	}

	public double areal() {
		return høyde * bredde;
	}
	
	public void tegn() {
		for (int i = 0; i < høyde; i++) {
			for (int j = 0; j < bredde; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
}
