
public class FivesScore extends Score {
	
	public FivesScore() {
		setName("Fives");
		
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 5) {
				score += 5;
			}
		}
		return score;
	} 
}

