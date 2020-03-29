import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class SimplePaintPanel extends JPanel {

	/**
     * Some constants to represent the color selected by the user.
     */
    private final static int WHITE = 0,
            RED = 1,     
            GREEN = 2,   
            BLUE = 3, 
            CYAN = 4,   
            MAGENTA = 5,
            YELLOW = 6;

    private Color currentColor = Color.WHITE;  // The currently selected drawing color,
                                       //   coded as one of the above constants

    // *** Let's make a nested class to define a new data type that will be stored in a data structure
    // e.g. (not a Rectangle[] rectangles)
    

    private ArrayList<Line> lines = new ArrayList<Line>(); 

	/**
     * Constructor for SimplePaintPanel class sets the background color to be
     * white and sets it to listen for mouse events on itself.
     */
    public SimplePaintPanel() {
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Fill with background color (white).

//        int width = getWidth();    // Width of the panel.
//        int height = getHeight();  // Height of the panel.
//
//        int colorSpacing = (height - 56) / 7;
//        
//        g.setColor(Color.GRAY);
//        g.drawRect(0, 0, width-1, height-1);  // one rectangle for each pixel 
//        g.drawRect(1, 1, width-3, height-3);
//        g.drawRect(2, 2, width-5, height-5);

        /* Draw a 56-pixel wide gray rectangle along the right edge of the panel.
             The color palette and Clear button will be drawn on top of this.
             (This covers some of the same area as the border I just drew. */

//        g.fillRect(width - 56, 0, 56, height);
//
//        /* Draw the "Clear button" as a 50-by-50 white rectangle in the lower right
//             corner of the panel, allowing for a 3-pixel border. */
//
//        g.setColor(Color.WHITE);
//        g.fillRect(width-53,  height-53, 50, 50);
//        g.setColor(Color.BLACK);
//        g.drawRect(width-53, height-53, 49, 49);
//        g.drawString("CLEAR", width-48, height-23); 
//
//        /* Draw the seven color rectangles. */
//
//        g.setColor(Color.BLACK);
//        g.fillRect(width-53, 3 + 0*colorSpacing, 50, colorSpacing-3);
//        g.setColor(Color.RED);
//        g.fillRect(width-53, 3 + 1*colorSpacing, 50, colorSpacing-3);
//        g.setColor(Color.GREEN);
//        g.fillRect(width-53, 3 + 2*colorSpacing, 50, colorSpacing-3);
//        g.setColor(Color.BLUE);
//        g.fillRect(width-53, 3 + 3*colorSpacing, 50, colorSpacing-3);
//        g.setColor(Color.CYAN);
//        g.fillRect(width-53, 3 + 4*colorSpacing, 50, colorSpacing-3);
//        g.setColor(Color.MAGENTA);
//        g.fillRect(width-53, 3 + 5*colorSpacing, 50, colorSpacing-3);
//        g.setColor(Color.YELLOW);
//        g.fillRect(width-53, 3 + 6*colorSpacing, 50, colorSpacing-3);

        /* Draw a 2-pixel white border around the color rectangle
             of the current drawing color. */

//        g.setColor(Color.WHITE);
//        g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
//        g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
 
        
        // *** Re-draw all of the information, based on the state of our data structure
        Color temp = Color.BLUE;
        for (int i = 0; i < lines.size(); i++) {
        	temp = lines.get(i).getColorCode();          
        	g.setColor(temp);
        	g.drawLine(lines.get(i).getX1(), lines.get(i).getY1(), lines.get(i).getX2(), lines.get(i).getY2());
        }
        
    } // end paintComponent()
    public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
    public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
	
//    public void changeColor(int y) {
//        int width = getWidth();           // Width of panel.
//        int height = getHeight();         // Height of panel.
//        int colorSpacing = (height - 56) / 7;  // Space for one color rectangle.
//        int newColor = y / colorSpacing;       // Which color number was clicked?
//        System.out.println("y: " + y + " colorSpacing: " + colorSpacing + " newColor: " + newColor);
//
//        if (newColor < 0 || newColor > 6)      // Make sure the color number is valid.
//            return;
//
//        currentColor = newColor;
//    } 

} // end class SimplePaint
