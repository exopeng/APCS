
public class FoursScore extends Score {
	
	public FoursScore() {
		setName("Fours");
		
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 4) {
				score += 4;
			}
		}
		return score;
	} 
}
