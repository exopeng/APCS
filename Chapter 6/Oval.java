import java.awt.Color;
import java.awt.Graphics;

public class Oval implements Drawable {
	private int x, y, width, height;
	private Color color;
	
	public Oval(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height );
		g.setColor(color);
		g.drawOval(x, y, width, height);
	}
	
	
}
