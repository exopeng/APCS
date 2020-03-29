//Ethan Peng
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This program demonstrates Focus events and Key events.  A colored square
 * is drawn on the panel.  By pressing the arrow keys, the user can move
 * the square up, down, left, or right.  By pressing the keys
 * R, G, B, or K, the user can change the color of the square to red,
 * green, blue, or black, respectively. The panel changes appearance when 
 * it has the input focus; a cyan-colored border is drawn around it.  
 * When it does not have the input focus, the message "Click to Activate" 
 * is displayed and the border is gray.  The panel should have focus
 * whenever the program window is active.
 * This class contains a main() routine so that it can be run as a program
 */
public class KeyboardAndFocusDemo extends JPanel {

    /**
     * The main program just opens a window that shows an object of type
     * KeyboardAndFocusDemo.  Note that it should request focus for the panel.
     * This has to be done after the window is made visible for it to have
     * any effect.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Keyboard and Focus Demo");
        window.setSize(400,400);
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        KeyboardAndFocusDemo content = new KeyboardAndFocusDemo();
        new KeyBoardListener(content);
        window.setContentPane(content);
        window.setVisible(true);
        //***something needs to be done here
        content.requestFocusInWindow();
    }

    private static final int SQUARE_SIZE = 50;  // Length of side of square.
    private Color squareColor;  // The color of the square.
    private int squareTop, squareLeft;  // Coordinates corner of square.


	public static int getSquareSize() {
		return SQUARE_SIZE;
	}


	/**
     * The constructor sets the initial position and color of the square
     * and registers itself to act as a listener for Key, Focus, and 
     * Mouse events.
     */
    public KeyboardAndFocusDemo() {

        squareTop = 100;  // Initial position of top-left corner of square.
        squareLeft = 100;
        squareColor = Color.RED;  // Initial color of square.

        setBackground(Color.WHITE);

    } // end constructor


    /**
     * Draws a border, square, and message in the panel.  The message and
     * the color of  the border depend on whether or not the pane has
     * the input focus.
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);  // Fills the panel with its
                                  // background color, which is white.
        //*** Draw a 3-pixel border, colored cyan if the panel has the
              //*** keyboard focus, or in light gray if it does not. */
        if (hasFocus()) {
        	g.setColor(Color.CYAN);
        }
        else {
        	g.setColor(Color.GRAY);
            	
        }
       
        int width = getSize().width;  // Width of the panel.
        int height = getSize().height; // Height of the panel.
        g.drawRect(0,0,width-1,height-1);
        g.fillRect(0, 0, width - 1, height - 1);
        
        g.setColor(Color.WHITE);
        g.drawRect(3,3,width-6,height-6);
        g.fillRect(3,3,width-6,height-6);

        //*** Draw the square.
        g.setColor(squareColor);
        g.drawRect(squareTop, squareLeft, SQUARE_SIZE, SQUARE_SIZE);
        g.fillRect(squareTop, squareLeft, SQUARE_SIZE, SQUARE_SIZE);
        

        /* Print a message that depends on whether the panel has the focus. */

        g.setColor(Color.MAGENTA);
        if (hasFocus()) {
            g.drawString("Arrow Keys Move Square",7,20);
            g.drawString("K, R, G, B Change Color",7,40);
        }
        else {
            g.drawString("Click to activate",7,20);
        }
    }  // end paintComponent()


	public Color getSquareColor() {
		return squareColor;
	}


	public void setSquareColor(Color squareColor) {
		this.squareColor = squareColor;
	}


	public int getSquareTop() {
		return squareTop;
	}


	public void setSquareTop(int squareTop) {
		this.squareTop = squareTop;
	}


	public int getSquareLeft() {
		return squareLeft;
	}


	public void setSquareLeft(int squareLeft) {
		this.squareLeft = squareLeft;
	}


} // end class KeyboardAndFocusDemo
