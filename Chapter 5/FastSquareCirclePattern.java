
public class FastSquareCirclePattern extends SquareCirclePattern {
	
	private int speed;
	
	public FastSquareCirclePattern(int x, int y, int width) {
		this(x, y, width, 1);
	}
	
	public FastSquareCirclePattern(int x, int y, int width, int speed) {
		super(x, y, width);
		this.speed = speed;
	}
	
	public void updatePosition() {
		for (int i = 0; i < speed; i++) {
			super.updatePosition();
		}
	}

}
