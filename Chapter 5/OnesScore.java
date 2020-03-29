public class OnesScore extends Score {
	public OnesScore() {
		setName("Ones");
		
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				score++;
			}
		}
		return score;
	} 
	
	
	
}
