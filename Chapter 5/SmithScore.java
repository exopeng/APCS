// *** Don't want to allow Score object to be instantiated
public abstract class SmithScore {
	// Instance variables: Each inherited Score 'has'
	// *** protected means subclasses can see it, no one else can
	private String name = "";
	private int value = 0;
	private boolean used = false;
	private int potentialValue = 0;
	
	public SmithScore(String name) { 
		this.name = name;
	}
	
	// force all subclasses to implement calculateScore
	// no implementation required
	public abstract int calculateScore(int[] values);

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
				
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public String getName() {
		return name;
	}
	
}
