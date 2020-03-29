import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DraggingDrawingPanelListener implements MouseListener, MouseMotionListener {
	private DrawingPanel panel;
	
	public DraggingDrawingPanelListener(DrawingPanel panel) {
		this.panel = panel;
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//alter the width and height
		panel.alterRectangle(e.getX(), e.getY());
		panel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.addRectangle(e.getX(), e.getY(), 0, 0, Color.BLUE);
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
