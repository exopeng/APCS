
public abstract class UnoCard {
	private String color;
	private int value;
	public UnoCard(String color) {
		this.color = color;
		
	}
	public UnoCard(String color, int value) {
		this.color = color;
		this.value = value;
		
	}
	
	public String getColor() {
		return color;
	}
	public int getValue() {
		return value;
	}
	public abstract void takeAction(Hand hand, Deck deck, Direction direction);
	
	public abstract String toString();
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
