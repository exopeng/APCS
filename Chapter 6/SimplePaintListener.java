import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;

public class SimplePaintListener implements MouseListener, MouseMotionListener, ActionListener, KeyListener {
	SimplePaintPanel panel;
	/* The following variables are used when the user is sketching a
    curve while dragging a mouse. */

	private int prevX, prevY;     // The previous location of the mouse.
	private boolean dragging;      // This is set to true while the user is drawing.
	
	public SimplePaintListener(SimplePaintPanel tPanel, ColorPanel tPanel1) {
		panel = tPanel;
		panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        panel.addKeyListener(this);
        tPanel.addKeyListener(this);
        
        tPanel1.getWhite().addActionListener(this);
        tPanel1.getRed().addActionListener(this);
        tPanel1.getGreen().addActionListener(this);
        tPanel1.getBlue().addActionListener(this);
        tPanel1.getCyan().addActionListener(this);
        tPanel1.getMagenta().addActionListener(this);
        tPanel1.getYellow().addActionListener(this);
        tPanel1.getClear().addActionListener(this);
        tPanel1.getCustom().addActionListener(this);
        //panel1.getSlider().addChangeListener(this);
	}
	@Override
	 /**
     * Called whenever the user moves the mouse while a mouse button is held down.  
     * If the user is drawing, draw a line segment from the previous mouse location 
     * to the current mouse location, and set up prevX and prevY for the next call.  
     * Note that in case the user drags outside of the drawing area, the values of
     * x and y are "clamped" to lie within this area.  This avoids drawing on the color 
     * palette or clear button.
     */
	public void mouseDragged(MouseEvent evt) {
        if (dragging == false)
            return;  // Nothing to do because the user isn't drawing.

        int x = evt.getX();   // x-coordinate of mouse.
        int y = evt.getY();   // y-coordinate of mouse.

//        if (x < 3)                          // Adjust the value of x,
//            x = 3;                           //   to make sure it's in
//        if (x > panel.getWidth() - 57)       //   the drawing area.
//            x = panel.getWidth() - 57;
//
//        if (y < 3)                          // Adjust the value of y,
//            y = 3;                           //   to make sure it's in
//        if (y > panel.getHeight() - 4)       //   the drawing area.
//            y = panel.getHeight() - 4;

        // *** update our data structure to reflect the new state as the user is dragging
        // Remember, NO DRAWING here!
        panel.getLines().add(new Line(prevX, prevY, x, y, panel.getCurrentColor()));
        prevX = x;
        prevY = y;
        panel.repaint();
        

    } // end mouseDragged()

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
     * This is called when the user presses the mouse anywhere in the panel.  
     * There are three possible responses, depending on where the user clicked:  
     * Change the current color, clear the drawing, or start drawing a curve.  
     * (Or do nothing if user clicks on the border.)
     */
	public void mousePressed(MouseEvent evt) {
        int x = evt.getX();   // x-coordinate where the user clicked.
        int y = evt.getY();   // y-coordinate where the user clicked.

//        int width = panel.getWidth();    // Width of the panel.
//        int height = panel.getHeight();  // Height of the panel.

        if (dragging == true)  // Ignore mouse presses that occur
            return;            //    when user is already drawing a curve.
                               //    (This can happen if the user presses
                               //    two mouse buttons at the same time.)
									//***like left button is down+dragging but you click the right button
//        if (x > width - 53) {
//            if (y > height - 53) {
//            			//  ***Clicked on "CLEAR button".
//                 panel.setLines(new ArrayList<Line>());
//                 panel.repaint();
//            }
//            else {
//                panel.changeColor(y);  // Clicked on the color palette.
//                 				// ***update the highlighted square of color
//                
//                panel.repaint();
//                
//            }
//        }
        else {
        	 prevX = x;
             prevY = y;
             dragging = true;
        }
//        else if (x > 3 && x < width - 56 && y > 3 && y < height - 3) {
//                // The user has clicked on the white drawing area.
//                // Start drawing a curve from the point (x,y).
//            prevX = x;
//            prevY = y;
//            dragging = true;
//        	
//        }

    } // end mousePressed()

	@Override
	 /**
     * Called whenever the user releases the mouse button. If the user was drawing 
     * a curve, the curve is done, so we should set dragging to false
     */
    public void mouseReleased(MouseEvent evt) {
        if (dragging == false)
        		return; // Nothing to do because the user isn't drawing.
        dragging = false;
    }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String op = e.getActionCommand();
        if (op.equals("White")) {
            panel.setCurrentColor(Color.WHITE);
	    } else if (op.equals("Red")) {
        	panel.setCurrentColor(Color.RED);
        } else if (op.equals("Green")) {
        	panel.setCurrentColor(Color.GREEN);
        } else if (op.equals("Blue")) 
        	panel.setCurrentColor(Color.BLUE);
    	 else if (op.equals("Cyan")) 
         	panel.setCurrentColor(Color.CYAN);
     	 else if (op.equals("Magenta")) 
         	panel.setCurrentColor(Color.MAGENTA);
     	 else if (op.equals("Yellow")) 
         	panel.setCurrentColor(Color.YELLOW);
     	 else if (op.equals("Clear")) {
         	panel.setLines(new ArrayList<Line>());
        	panel.repaint();
     	 } else if (op.equals("Custom")) {
            JColorChooser jcc = new JColorChooser();
            Color c = jcc.showDialog(null, "", Color.BLUE);
            panel.setCurrentColor(c);
     	 } else if (op.equals("Quit")) {
     		 System.exit(0);
     	 } else if (op.equals("Undo")) {
     		 panel.getLines().remove(panel.getLines().size() - 1);
     		 panel.repaint();
     	 }
        panel.requestFocusInWindow();
        
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.isMetaDown() && e.getKeyChar() == 'z') {
			panel.getLines().remove(panel.getLines().size() - 1);
			panel.repaint();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
