import java.awt.Graphics;
import javax.swing.JPanel;

public class RectanglePanel extends JPanel {
	// instance variables: 
	private int numRectangles = 0;
	private Rectangle[] rectangles = new Rectangle[20000];
	
	// system calls every time you resize
	// system will call when you call repaint() 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// redraw, from scratch, our current state of rectangles
		g.drawString("Press x to delete, Press right arrow to move rectangles", 10, 10);
		for (int i = 0; i < numRectangles; i++) {
		    rectangles[i].draw(g);
		}
	}
	
	public void addRectangle(Rectangle rectangle) {
	    if (numRectangles == rectangles.length || rectangle == null)
	        return;
	    rectangles[numRectangles] = rectangle;
	    numRectangles++;
	}
	
	
	// *** (2) note there are 2 versions of containsPoint methods
	// what do you think containsPoint from a RectanglePanel's perspective is doing?
	//finds the first rectangle that contains that point
	public Rectangle containsPoint(int x, int y) {
		for (int i = numRectangles - 1; i >= 0; i--) {
		    if (rectangles[i].containsPoint(x, y))
		    		return rectangles[i];
		}
		return null;
	}
	public void shiftAllLeft() {
		for (int i = 0; i < numRectangles; i++) {
			rectangles[i].setX(rectangles[i].getX() - 10);
		}
	}
	public void shiftAllRight() {
		for (int i = 0; i < numRectangles; i++) {
			rectangles[i].setX(rectangles[i].getX() + 10);
		}
	}

	public int getNumRectangles() {
		return numRectangles;
	}

	public void setNumRectangles(int numRectangles) {
		this.numRectangles = numRectangles;
	}

	public Rectangle[] getRectangles() {
		return rectangles;
	}

	public void setRectangles(Rectangle[] rectangles) {
		this.rectangles = rectangles;
	}

}
