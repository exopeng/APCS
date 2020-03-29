
public class YahtzeeDice {
	//instance vars
	Die[] dice = new Die[5];
	
	//constructors
	public YahtzeeDice() {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Die();
		}
	}
	
	public YahtzeeDice(int numSides) {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Die(numSides);
		}
	}
	
	
	public int roll() {
		int sum = 0;
		for (int i = 0; i < dice.length; i++) {
			sum += dice[i].roll();
		}
		return sum;
	}
	
	public int roll(boolean[] array) {
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < dice.length; i++) {
			if (!array[i]) {
				temp = dice[i].roll();
			} else {
				temp = dice[i].getCurrentValue();
			}
			sum += temp;
		}
		return sum;
	}
	
	public Die[] getDice()  {//returns the dice array 
		return dice;
	}
	public int[] getDiceValues() {
		int[] array = new int[dice.length];
		for (int i = 0; i < dice.length; i++) {
			array[i] = dice[i].getCurrentValue();
		}
		return array;
	}
	public String toString() {
		String fin = "";
		for (int i = 0; i < dice.length; i++) {
			fin += dice[i].toString() + " ";
		}
		return fin;
	} 
	
}
