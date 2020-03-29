import java.awt.Color;
import java.awt.Graphics;


public class SquareCirclePatternWithHat extends SquareCirclePattern {
	
	private Color color;
	
	public SquareCirclePatternWithHat(int x, int y, int width, Color color) {
		super(x, y, width);
		this.color = color;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(color);
		g.fillRect(getX(), getY() - getWidth() / 4, getWidth(), getWidth() / 4);
		g.setColor(Color.black);
		g.drawRect(getX(), getY() - getWidth() / 4, getWidth(), getWidth() / 4);
	}

}
