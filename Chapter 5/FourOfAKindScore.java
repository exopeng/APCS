
public class FourOfAKindScore extends Score  {

	public FourOfAKindScore() {
		setName("FourOfAKind");
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < 4; i++) {
			int checkNum = array[i];
			int count = 1;
			for (int j = 0; j < array.length; j++) {
				if (j != i) {
					if (array[j] == checkNum) {
						count++;
					}
				}
				
			}
			if (count >= 4) {
				for (int e = 0; e < array.length; e++) {
					score += array[e];
					
				}
				break;
			}
		}
		
		return score;
	}
}


