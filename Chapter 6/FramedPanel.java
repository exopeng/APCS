import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FramedPanel extends JPanel {
	private Color color;
	private Drawable[] shapes = new Drawable[200];
	private int counter = 0;
	
	public FramedPanel(Color color) {
		this.color = color;
	}
	
	public Drawable[] getShapes() {
		return shapes;
	}

	public void setShapes(Drawable[] shapes) {
		this.shapes = shapes;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int borderLen = Math.min(this.getWidth() / 20, this.getHeight() / 20);
		g.setColor(this.color);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(borderLen, borderLen, this.getWidth() - borderLen * 2, this.getHeight() - borderLen * 2);
		g.setColor(Color.WHITE);
		g.fillRect(borderLen, borderLen, this.getWidth() - borderLen * 2, this.getHeight() - borderLen * 2);
		
		for (int i = 0; i < counter; i++) {
			shapes[i].draw(g);
		}
	}
	
	public void addRectangle(int x, int y, int width, int height, Color color) {
		shapes[counter] = new Rectangle(x, y, width, height, color);
		counter++;
	}
	
	public void addOval(int x, int y, int width, int height, Color color) {
		shapes[counter] = new Oval(x, y, width, height, color);
		counter++;
	}
	
}
