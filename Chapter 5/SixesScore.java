
public class SixesScore extends Score {
	
	public SixesScore() {
		setName("Sixes");
		
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 6) {
				score += 6;
			}
		}
		return score;
	} 
}
