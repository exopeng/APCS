import java.awt.Graphics;

public class RoundRectangle implements Drawable {

	private int width;
	private int height;
	private int x;
	private int y;

	public RoundRectangle() {
		width = 	(int)(Math.random()*RAND_FACTOR);
		height =  (int)(Math.random()*RAND_FACTOR);
		x =  (int)(Math.random()*RAND_FACTOR);
		y = (int)(Math.random()*RAND_FACTOR); 

		
	}
	
	public void draw(Graphics g) {
		g.drawRoundRect(x, y, width, height, 20, 20);
	}
	
	
}