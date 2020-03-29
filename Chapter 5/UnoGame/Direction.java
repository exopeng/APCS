
public class Direction {
	private boolean clockWise;
	
	public Direction(boolean clockWise) {
		this.clockWise = clockWise;
	}

	public boolean getClockWise() {
		return clockWise;
	}

	public void setClockWise(boolean clockWise) {
		this.clockWise = clockWise;
	}
	
	public String toString() {
		if (clockWise) {
			return "clockWise, 1, 2, 3, 1, 2, 3...";
		} else {
			return "counterClockwise, 1, 3, 2, 1, 3, 2...";
		}
	}
	
	
}
