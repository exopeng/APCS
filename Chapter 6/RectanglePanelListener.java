import java.awt.Color;
import java.awt.event.*;

import javax.swing.Timer;

public class RectanglePanelListener implements MouseListener, MouseMotionListener, KeyListener, ActionListener {

	private RectanglePanel rectPanel;
	
	//***Reference to the Rectangle we are dragging.  This is like Method 2 
	// that we did in class.  Remember, if we save this reference, we can change
	// the state of the Rectangle being dragged, without having to delete and redraw
	// Rectangles constantly
	private Rectangle currentlyDraggingRectangle = null;
	
	private int offsetX, offsetY;  
	private boolean dragging;
	
	public RectanglePanelListener(RectanglePanel panel) {
		rectPanel = panel;  // save reference to the panel we are listening on
		rectPanel.addMouseListener(this); // register listener with panel
		rectPanel.addMouseMotionListener(this);
		rectPanel.addKeyListener(this);
		Timer myTimer = new Timer(1000, this);
		myTimer.start();
		dragging = false;
	}

	// mouseClicked (press/release in same spot) means I want to create a new rectangle 
	// mousePressed (press and hold) means I'm going to possibly start dragging a rectangle
	@Override 
	public void mouseClicked(MouseEvent ev) {
		int width = 30;						
		int height = 20;
		Color color;
		if (ev.isMetaDown()) {
			color = Color.BLUE;
		}
		else {
			color = Color.RED;
		}
		// modify state to include a new rectangle
		rectPanel.addRectangle(new Rectangle(ev.getX(), ev.getY(), width, height, color));
		// repaint so user can see this new state
		rectPanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent ev) {  }

	@Override
	public void mouseExited(MouseEvent ev) { 
		currentlyDraggingRectangle = null;
	}

	@Override
	public void mousePressed(MouseEvent ev) { 
		//save initial points
		offsetX = ev.getX();
		offsetY = ev.getY();
		currentlyDraggingRectangle = rectPanel.containsPoint(offsetX, offsetY);
		if (currentlyDraggingRectangle == null) {
			dragging = false;
		} else {
			dragging = true;
		}
		
	}

	public void mouseReleased(MouseEvent ev) { 
		dragging = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//update with translation
		if (dragging) {
			int x = e.getX();
			int y = e.getY();
			currentlyDraggingRectangle.setX(currentlyDraggingRectangle.getX() + (x - offsetX));
			currentlyDraggingRectangle.setY(currentlyDraggingRectangle.getY() + (y - offsetY));
			offsetX = x;
			offsetY = y;
			rectPanel.repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		rectPanel.shiftAllLeft();
		rectPanel.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		if (key == 'X' || key == 'x') {
			rectPanel.setRectangles(new Rectangle[20000]);
			rectPanel.setNumRectangles(0);
			rectPanel.repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_RIGHT) {
			rectPanel.shiftAllRight();
			rectPanel.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	

}
