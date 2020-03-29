import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FramedPanelMouseListener implements MouseListener {
	private FramedPanel panel;
	
	public FramedPanelMouseListener(FramedPanel panel) {
		this.panel = panel;
		panel.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Color color;
		if (e.isMetaDown()) {
			color = Color.RED;
			panel.addOval(e.getX(), e.getY(), 30, 30, color);
		} else if (e.isAltDown()) {
			color = Color.BLUE;
			panel.addOval(e.getX(), e.getY(), 30, 30, color);
		} else if (e.isShiftDown()) {
			color = Color.BLUE;
			panel.addRectangle(e.getX(), e.getY(), 30, 30, color);
		} else if (e.isControlDown()) {
			panel.setShapes(new Drawable[200]);
			panel.setCounter(0);
		} else {
			color = Color.RED;
			panel.addRectangle(e.getX(), e.getY(), 30, 30, color);
		}
		panel.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
