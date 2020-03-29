// *** Your name: Ethan Peng
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CirclePanelListener implements MouseListener, MouseMotionListener{
	
	private CirclePanel circlePanel;
	private Circle currentlyDraggedCircle = null;
	private int offsetX;
	private int offsetY;
	private Color colorOfNewlyCreatedCircles = Color.red;
	private int radiusOfNewlyCreatedCircles = 30;
	
	public CirclePanelListener(CirclePanel panel) {
		circlePanel = panel;
		circlePanel.addMouseListener(this);
		circlePanel.addMouseMotionListener(this);
	}
	
	public void setColorOfNewlyCreatedCircles(Color color) {
		colorOfNewlyCreatedCircles = color;
	}
	
	public void setRadiusOfNewlyCreatedCircles(int radius) {
		radiusOfNewlyCreatedCircles = radius;
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		//implement this method to add a circle to circlePanel
		//the circle should have the color and radius specified by
		//colorOfNewlyCreatedCircles and radiusOfNewlyCreatedCircles
		//the center of the created circle should be at the click location
		//circle constructor should take in the center x and center y
		circlePanel.addCircle(new Circle(ev.getX() , ev.getY(), radiusOfNewlyCreatedCircles, colorOfNewlyCreatedCircles));
		circlePanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent ev) { }

	@Override
	public void mouseExited(MouseEvent ev) { 
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		//implement this method in conjunction with the mouseDragged
		//method to be able to drag circles in the circlePanel
		offsetX = ev.getX();
		offsetY = ev.getY();
		currentlyDraggedCircle = circlePanel.containsPoint(offsetX, offsetY);
	}

	@Override
	public void mouseReleased(MouseEvent ev) { 
		currentlyDraggedCircle = null;
	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		//implement this method in conjunction with the mousePressed
		//method to be able to drag circles in the circlePanel
		if (currentlyDraggedCircle != null) {
			currentlyDraggedCircle.setX(currentlyDraggedCircle.getX() + (ev.getX() - offsetX));
			currentlyDraggedCircle.setY(currentlyDraggedCircle.getY() + (ev.getY() - offsetY));
			offsetX = ev.getX();
			offsetY = ev.getY();
			circlePanel.repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent ev) { }

}
