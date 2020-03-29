
public abstract class Score {
	protected String name;
	protected boolean taken;
	protected int val;
	public abstract int calculateScore(YahtzeeDice dice);
	
	public Score() {
		taken = false;
		val = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	public int[] getTallies(int[] array) {
		int[] newArray = new int[6];
		for (int i = 0; i < array.length; i++) {
			switch (array[i]) {
			case 1:
				newArray[0]++;
				break;
			case 2:
				newArray[1]++;
				break;
			case 3:
				newArray[2]++;
				break;	
			case 4:
				newArray[3]++;
				break;
			case 5:
				newArray[4]++;
				break;
			case 6:
				newArray[5]++;
			}
		}
		return newArray;
	}
	
	
	
}
