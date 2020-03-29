public class YahtzeeScore extends Score {
	
	public YahtzeeScore() {
		setName("Yahtzee");
	}
	
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int checkNum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] != checkNum) {
				return 0;
			}
		}
		
		return 50;
	}
}
