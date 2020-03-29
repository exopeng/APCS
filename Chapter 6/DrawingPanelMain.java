import javax.swing.*;

public class DrawingPanelMain {
	public static void main(String[] args) {
		JFrame window = new JFrame("Rectangles!");
		window.setSize(400, 600);
		window.setLocation(500, 300);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel content = new DrawingPanel();
		DraggingDrawingPanelListener listener = new DraggingDrawingPanelListener(content);
		window.setContentPane(content);
		window.setVisible(true);
		content.requestFocusInWindow();
	}
}
