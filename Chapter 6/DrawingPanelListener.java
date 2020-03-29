import java.awt.Color;
import java.awt.event.*;
public class DrawingPanelListener implements MouseListener{
	
	
	//save a reference to the event-generating component(DrawingPanel)
	//that I am listening for
	private DrawingPanel panel;
	
	
	public DrawingPanelListener(DrawingPanel panel) {
		this.panel = panel;
		//component.addXXXListner(listener)
		panel.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//no drawing in here!! no work with Graphics g
	//only work with graphics in paintComponent()
	//set the state of instance variables to include a new Rectangle
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Color c;
		if (e.isMetaDown()) {
			c = Color.BLUE;
		} else if (e.isShiftDown()) {
			c = Color.GREEN;
		} else {
			c = Color.RED;
		}
		panel.addRectangle(e.getX(), e.getY(), 100, 100, c);
		panel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
