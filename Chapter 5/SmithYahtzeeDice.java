public class SmithYahtzeeDice {

	// static: only one copy.  Associated with the class. 
	public static final int YAHTZEE_NUM = 5; 
	
	// instance variable: each YahtzeeDice object gets
	// their own copy
	private Die[] dice = new Die[YAHTZEE_NUM];  
	
	// default constructor.
	public SmithYahtzeeDice() {  
		for(int i = 0; i < YAHTZEE_NUM; i++) {
			dice[i] = new Die(); 
		}
	}

	//constructs a Yahtzee object containing 5 Die objects with the given number of sides 
	public SmithYahtzeeDice(int numSides) {
		for(int i = 0; i < YAHTZEE_NUM; i++) {
			dice[i] = new Die(numSides); 
		}
	}
	
	public int rollAll() { //rolls all 5 dice and returns the total of the dice
		int sum = 0;
		for(int i = 0; i < YAHTZEE_NUM; i++) {
			sum += dice[i].roll();
		}
		return sum;
	}
	
	public int rollSome(boolean[] held) {
		int sum = 0;
		for(int i = 0; i < YAHTZEE_NUM; i++) {
			if(held[i]) //if held, return what's already there, also don't roll it
				sum += dice[i].getCurrentValue();
			else
				sum += dice[i].roll();
		}
		return sum;
	}
	
	//returns the dice array
	public Die[] getDice() {  
		return dice;
	}
	
	 //returns an int[] containing the values of the 5 dice
	public int[] getDiceValues() { 
		int[] diceValues = new int[YAHTZEE_NUM];
		for(int i = 0; i < dice.length; i++) {
			diceValues[i] = dice[i].getCurrentValue();
		}
		return diceValues;
	}
	
	//returns a String representation of the object
	public String toString() {
		String yahtzee = "The " + YAHTZEE_NUM + " dice read: ";
		
		for(int i = 0; i < dice.length; i++) {
			if(i < dice.length - 1)	
				yahtzee += dice[i].getCurrentValue() + ", ";
			else
				yahtzee += dice[i].getCurrentValue() + ".";
		}
		return yahtzee;
	}

}