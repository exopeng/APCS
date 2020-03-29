public class SmithOnesScore extends SmithScore {
	
	public SmithOnesScore(String name) {
		super(name);
	}

	// return sum of all 1's
	public int calculateScore(int[] values) {
		int sumOfOnes = 0;
		for(int i = 0; i < values.length; i++) {
			if(values[i] == 1)
				sumOfOnes += 1;
		}
		return sumOfOnes;
	} 
}
