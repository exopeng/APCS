
public class TwosScore extends Score {
	
	public TwosScore() {
		setName("Twos");
		
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 2) {
				score += 2;
			}
		}
		return score;
	} 
}