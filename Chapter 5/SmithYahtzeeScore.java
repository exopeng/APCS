public class SmithYahtzeeScore extends SmithScore {
	public SmithYahtzeeScore(String s) {
		super(s); 
	}
	
	// return 50 or 0 based on if Yahtzee
	public int calculateScore(int[] values) {
		// (Wrong logic in here)
		int[] numbers = new int[6]; 
		boolean isYahtzee = true;
		
		if(isYahtzee) {
			return 50;
		}
		else {
			return 0;
		}
			
	} 
}
