import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimpleAnimationStarterNew extends JPanel implements ActionListener {
	private Circle c1;
	private Circle c2;
	private Circle c3;
	private OlympicCircles o1 = new OlympicCircles(50, 50, 70);
	
	public SimpleAnimationStarterNew() {
		c1 = new Circle();
		c2 = new Circle(20, 20, 50, Color.GREEN);
		c3 = new Circle(100, 200, 90, Color.BLUE);
		
	}
	public void drawFrame(Graphics g, int frameNumber, int width, int height) {
		c1.draw(g);
		c2.draw(g);
		c3.draw(g);
		c1.setX(c1.getX() + 1);
		c2.setRadius(c2.getRadius() + 1);
		o1.draw(g);
	}

	//------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


	public static void main(String[] args) {

		/* NOTE:  The string in the following statement goes in the title bar
		 * of the window.
		 */
		JFrame window = new JFrame("Simple Animation");

		/*
		 * NOTE: If you change the name of this class, you must change
		 * the name of the class in the next line to match!
		 */
		SimpleAnimationStarterNew drawingArea = new SimpleAnimationStarterNew();

		drawingArea.setBackground(Color.WHITE);
		window.setContentPane(drawingArea);

		/* NOTE:  In the next line, the numbers 600 and 450 give the
		 * initial width and height of the drawing array.  You can change
		 * these numbers to get a different size.
		 */
		drawingArea.setPreferredSize(new Dimension(600,450));

		window.pack();
		window.setLocation(100,50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		/*
		 * Note:  In the following line, you can change true to
		 * false.  This will prevent the user from resizing the window,
		 * so you can be sure that the size of the drawing area will
		 * not change.  It can be easier to draw the frames if you know
		 * the size.
		 */
		window.setResizable(true);

		/* NOTE:  In the next line, the number 20 gives the time between
		 * calls to drawFrame().  The time is given in milliseconds, where
		 * one second equals 1000 milliseconds.  You can increase this number
		 * to get a slower animation.  You can decrease it somewhat to get a
		 * faster animation, but the speed is limited by the time it takes
		 * for the computer to draw each frame. 
		 */
		Timer frameTimer = new Timer(10,drawingArea);

		window.setVisible(true);
		frameTimer.start();

	} // end main

	private int frameNum;

	public void actionPerformed(ActionEvent evt) {
		frameNum++;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawFrame(g, frameNum, getWidth(), getHeight());
	}

}
