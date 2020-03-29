import java.awt.*;

public class OlympicCircles {
	//instance vars
	private Circle[] circles;
	
	//constructor
	public OlympicCircles(int x, int y, int r) {
		circles = new Circle[5];
		circles[0] = new Circle(x, y, r, Color.BLUE);
		circles[1] = new Circle(x + 2 * r, y, r, Color.BLACK);
		circles[2] = new Circle(x + 4 * r, y, r, Color.RED);
		circles[3] = new Circle(x + r, y + r, r, Color.YELLOW);
		circles[4] = new Circle(x + 3 * r, y + r, r, Color.GREEN);
	}
	//instance methods - behaviors
	public void draw(Graphics g) {
		for (int i = 0; i < circles.length; i++) {
			circles[i].draw(g);
		}
	}
	
}
