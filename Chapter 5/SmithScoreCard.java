public class SmithScoreCard {
	
	private final int NUM_SCORES = 4;
	// Can hold any type of Score object
	private SmithScore[] scores = new SmithScore[NUM_SCORES];

	public final static int ONES_INDEX = 0;
	public final static int TWOS_INDEX = 1;
	public final static int CHANCE_INDEX = 2;
	public final static int YAHTZEE_INDEX = 3;
	 
	// constructor: 
	// initialize your different Score objects within the ScoreCard
	public SmithScoreCard() {		
		// Since all these classes inherit from Score, 
		// they can all go in Score[]
		scores[ONES_INDEX] = new SmithOnesScore("Ones");
		scores[TWOS_INDEX] = new SmithTwosScore("Twos");
		scores[CHANCE_INDEX] = new SmithChanceScore("Chance");
		scores[YAHTZEE_INDEX] = new SmithYahtzeeScore("Yahtzee");		
	}
	
	
	public String getPotentialScores(int[] values) {
		String result = "***Potential Scores***\n";

		// goes through each type of Score (that hasn't been picked yet), 
		// and calls method to calculate what the potential value is.  
		for(int i = 0; i < NUM_SCORES; i++) {
			if(!scores[i].isUsed()) 
				result += String.format("%-20s", (i+1) + ": " + scores[i].getName() + " (" + 
							scores[i].calculateScore(values) + ")");
			
			// Add spacing for visuals
			if(i > 0 && i % 3 == 0) {
				result += "\n";
			}
		}
		return result;
	}
	
	// Conceptually, this is beautiful.  .toString() should return the 
	// String representation of the object.  
	// What does it mean to print out the String representation of "ScoreCard"?
	// Well, it means to print out the scores, which is easy with inheritance
	public String toString() {
		String scoreString = "***Current Scorecard***\n";
		for(int i = 0; i < NUM_SCORES; i++) {
			scoreString += String.format("%-20s", scores[i].getName() + ": " + scores[i].getValue());
			
			// Add spacing for visuals
			if(i > 0 && i % 3 == 0) {
				scoreString += "\n";
			}
		}
		scoreString += "Total Score: (unimplemented)";
		return scoreString;
	}  
	
	
}
