// *** Your name: Ethan Peng
import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	
	private int x;
	private int y;
	private int radius;
	private Color color;
	
	//x and y represent the center of the circle
	public Circle(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
		g.setColor(Color.black);
		g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return 2 * radius;
	}
	
	public int getHeight() {
		return 2 * radius;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public boolean containsPoint(int x, int y) {
		//implement this method
		int centerX = this.x;
		int centerY = this.y;
		double distance = Math.sqrt(Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2));
		if (distance <= radius) {
			return true;
		} 
		return false;
	}
}
