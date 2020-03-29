
public class ChanceScore extends Score {
	
	public ChanceScore() {
		setName("Chance");
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < array.length; i++) {
			score += array[i];
		}
		return score;
	} 
}
