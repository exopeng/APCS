import java.awt.Color;
import java.awt.Graphics;

public class SquareCirclePattern implements Animatable {
	
	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private int currentDirection;
	private int numStepsInCurrentDirection;
	private int numStepsPerDirection;
	private int pixelsPerStep;
	
	public SquareCirclePattern(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = width;
		this.color = Color.RED;
		this.currentDirection = RIGHT;
		this.numStepsInCurrentDirection = 0;
		this.numStepsPerDirection = 100;
		this.pixelsPerStep = 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void updatePosition() {
		if (numStepsInCurrentDirection >= numStepsPerDirection) {
			currentDirection = nextDirection();
			numStepsInCurrentDirection = 0;
		}
		move();
	}
	
	private int nextDirection() {
		return (currentDirection + 1) % 4;
	}
	
	private void move() {
		numStepsInCurrentDirection++;
		switch(currentDirection) {
		case UP:	 y -= pixelsPerStep;
				return;
		case DOWN: y += pixelsPerStep;
				return;
		case LEFT: x -= pixelsPerStep;
				return;
		case RIGHT: x += pixelsPerStep;
		}
	}
	
	public void draw(Graphics g) {
		Color savedColor = g.getColor();
		color = Color.red;
		int offset = 0;
		int count = 0;
		while (offset < width / 2) {
			g.setColor(color);
			g.fillRect(x + offset, y + offset, width - 2 * offset, height - 2 * offset);
			g.setColor(Color.BLACK);
			g.drawRect(x + offset, y + offset, width - 2 * offset, height - 2 * offset);
			nextColor();
			g.setColor(color);
			g.fillOval(x + offset, y + offset, width - 2 * offset, height - 2 * offset);
			g.setColor(Color.BLACK);
			g.drawOval(x + offset, y + offset, width - 2 * offset, height - 2 * offset);
			nextColor();
			count++;
			offset = (int)((width * (1 - Math.pow(1/Math.sqrt(2), count)))/2);
		}
		g.setColor(savedColor);

	}
	
	private void nextColor() {
		if (color.equals(Color.RED)) {
			color = Color.YELLOW;
		}
		else if (color.equals(Color.YELLOW)) {
			color = Color.green;
		}
		else if (color.equals(Color.green)) {
			color = Color.pink;
		}
		else if (color.equals(Color.pink)) {
			color = Color.blue;
		}
		else if (color.equals(Color.blue)) {
			color = Color.RED;
		}
	}
}
