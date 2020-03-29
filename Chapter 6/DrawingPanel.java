import java.awt.*;
import javax.swing.*;

public class DrawingPanel extends JPanel {
	//store "state" in instance variables(data structure)
	// instance variables represent state.
	private int counter = 0;
	private Rectangle[] rects = new Rectangle[20000];
	
	// Override default JPanel method.
	// NEVER call manually.  System calls. 
	// You should call repaint(); 
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //fill with background color
	
		g.setColor(Color.PINK);
//		
//		int x = (int)(Math.random() * 300);
//		int y = (int)(Math.random() * 300);
//		int width = (int)(Math.random() * 200) + 20;
//		int height = (int)(Math.random() * 200) + 20;
//		
//		//create a new Point obj, save in data structure
//		//that way, I can recreate it it every time paintComponent() is called
//		Rectangle rect = new Rectangle(x, y, width, height, getRandomColor());
//		rects[counter] = rect;
		
		//recreate last states
		for (int i = 0; i < counter; i++) {
			rects[i].draw(g);
		}
		
		
	}
	public void addRectangle(int x, int y, int width, int height, Color color) {
		rects[counter] = new Rectangle(x, y, width, height, color);
		counter++;
	}
	public void alterRectangle(int x, int y) {
		//Rectangle temp = new Rectangle(rects[counter - 1].getX(), rects[counter - 1].getY(),Math.abs(rects[counter - 1].getX() - x), Math.abs(rects[counter - 1].getY() - y), rects[counter - 1].getColor());
		Rectangle temp = new Rectangle(rects[counter - 1].getX(), rects[counter - 1].getY(),(x - rects[counter - 1].getX()), ( y - rects[counter - 1].getY() ), rects[counter - 1].getColor());
		rects[counter - 1] = temp;
	}
	
	
}