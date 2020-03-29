import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

// This demos having the Listener class be NESTED inside the component (JPanel that generates the events)
// Note that this allows access to instance variables and methods like repaint() without saving a reference
// or having to write public methods to access the member variables keeping track of state e.g. 'message'  
public class SmithPanelWithNestedListener extends JPanel {

	String message; 

	// Kind of awkward conceptually to have main here, but to keep everything in one file...
	public static void main(String[] args) {
		JFrame window = new JFrame("Test2");
		window.setVisible(true);
		window.setSize(400,600);
		window.setLocation(300,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new SmithPanelWithNestedListener());
	}
	
	public SmithPanelWithNestedListener() {
		message = "default";
		this.addMouseListener(new SmithPanelListener());
	}
	
	private class SmithPanelListener implements MouseListener {
		// The method of saving a reference to SmithPanel isn't necessary b/c it's nested
		// Plus, we wouldn't be able to call the constructor directly in main() to this private nested class
		
		public void mouseClicked(MouseEvent e) {
			message = "mouse clicked"; //this refers to listener
			repaint(); //nested, access to SmithPanel
			
		}
		public void mousePressed(MouseEvent e) {
			message = "mouse pressed";
			repaint(); //nested, access to SmithPanel

		}
		public void mouseReleased(MouseEvent e) {
			message = "mouse released";
			repaint(); //nested, access to SmithPanel

		}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}

	
	// draws based on state set by member variables
	public void paintComponent(Graphics g) {
		g.drawString(message, 100, 100);
	}
	

}
