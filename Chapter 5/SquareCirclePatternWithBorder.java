import java.awt.Color;
import java.awt.Graphics;
	
public class SquareCirclePatternWithBorder extends SquareCirclePattern {

	public SquareCirclePatternWithBorder(int x, int y) {
		super(x, y, 100);
	}
	
	public SquareCirclePatternWithBorder(int x, int y, int width) {
		super(x, y, width);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(getX() - getWidth() / 10, getY() - getWidth() / 10,
				   getWidth() + 2 * getWidth() / 10, getWidth() + 2 * getWidth() / 10);
		super.draw(g);
	}

}
