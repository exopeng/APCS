
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPanelMain {
	
	public static void main(String[] args) {
		JFrame window  = new JFrame("Title");
		window.setSize(400, 600);
		window.setLocation(0, 0);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new TestPanel();
		window.setContentPane(content);
		
		window.setVisible(true);
	}

}
