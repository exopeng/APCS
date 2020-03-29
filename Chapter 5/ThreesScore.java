public class ThreesScore extends Score {
	
	public ThreesScore() {
		setName("Threes");
		
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 3) {
				score += 3;
			}
		}
		return score;
	} 
}