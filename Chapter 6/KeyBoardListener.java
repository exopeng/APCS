import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener, FocusListener {
	KeyboardAndFocusDemo rectPanel;
	public KeyBoardListener(KeyboardAndFocusDemo panel) {
		rectPanel = panel;
		rectPanel.addKeyListener(this);
		rectPanel.addFocusListener(this);
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		rectPanel.repaint();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		rectPanel.repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		if (key == 'B' || key == 'b') {
			rectPanel.setSquareColor(Color.BLUE);
			rectPanel.repaint();
		}
		if (key == 'G' || key == 'g') {
			rectPanel.setSquareColor(Color.GREEN);
			rectPanel.repaint();
		}
		if (key == 'K' || key == 'k') {
			rectPanel.setSquareColor(Color.BLACK);
			rectPanel.repaint();
		}
		if (key == 'R' || key == 'r') {
			rectPanel.setSquareColor(Color.RED);
			rectPanel.repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_RIGHT) {
			if (rectPanel.getSquareTop() + rectPanel.getSquareSize() + 8 > rectPanel.getWidth()) {
				
			} else {
				rectPanel.setSquareTop(rectPanel.getSquareTop() + 8);
				rectPanel.repaint();
			}
			
		}
		if (code == KeyEvent.VK_LEFT) {
			if (rectPanel.getSquareTop() - 8 < 0) {
				
			} else {
				rectPanel.setSquareTop(rectPanel.getSquareTop() - 8);
				rectPanel.repaint();
			}
			
		}
		if (code == KeyEvent.VK_UP) {
			if (rectPanel.getSquareLeft() - 8 < 0) {
				
			} else {
				rectPanel.setSquareLeft(rectPanel.getSquareLeft() - 8);
				rectPanel.repaint();
			}
			
		}
		if (code == KeyEvent.VK_DOWN) {
			if (rectPanel.getSquareLeft() + 8 + rectPanel.getSquareSize() > rectPanel.getHeight())  {
				
			} else {
				rectPanel.setSquareLeft(rectPanel.getSquareLeft() + 8);
				rectPanel.repaint();
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
