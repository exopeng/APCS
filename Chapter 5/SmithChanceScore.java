public class SmithChanceScore extends SmithScore{
	
	public SmithChanceScore(String s) {
		super(s); // call constructor for superclass
	}
 
	// return sum of all values
	public int calculateScore(int[] values) {		
		int total = 0;
		for(int i = 0; i < values.length; i++) {
			total += values[i];
		}
		return total;
	} 
}
