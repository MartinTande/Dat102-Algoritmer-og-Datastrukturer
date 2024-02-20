package oppgave3;

public class FraktalTrekant extends Fraktal{

	public FraktalTrekant(int depth, int delay, Tegneflate canvas) {
		super(depth, delay, canvas);
	}

	@Override
	public void tegn() {
		drawTriangle(depth, 0, 800, 800, 800, 400, 0);
	}
	
	private void drawTriangle(int level, int p1X, int p1Y, int p2X, int p2Y, int p3X, int p3Y) {
		canvas.tegnTrekant(p1X, p1Y, p2X, p2Y, p3X, p3Y);
		ventMillis(delay);
	    
	    if (level > 0) {
//	    	drawTriangle(level-1, p1X, p1Y, (p1X+p2X)/2, (p1Y+p2Y)/2, (p1X+p2X)/4, (p1Y+p3Y)/2);	//Bottom left
	    	drawTriangle(level-1, (p1X+p2X)/2, (p1Y+p2Y)/2, p2X, p2Y, p2X+(p1X+p2X)/4, p2Y+(p1Y+p3Y)/2);	// Bottom right
	    }
	}
}
