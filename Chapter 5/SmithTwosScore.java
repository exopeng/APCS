public class SmithTwosScore extends SmithScore {
	
	public SmithTwosScore(String name) {
		super(name); 
	}
	 
	// return sum of all 2's
	public int calculateScore(int[] values) {
		int sumOfTwos = 0;
		for(int i = 0; i < values.length; i++) {
			if(values[i] == 2)
				sumOfTwos += 2;
		}
		return sumOfTwos;
	} 
}