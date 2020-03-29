
public class ThreeOfAKindScore extends Score {
	
	public ThreeOfAKindScore() {
		setName("ThreeOfAKind");
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int score = 0;
		for (int i = 0; i < 3; i++) {
			int checkNum = array[i];
			int count = 1;
			for (int j = 0; j < array.length; j++) {
				if (j != i) {
					if (array[j] == checkNum) {
						count++;
					}
				}
			}
			if (count >= 3) {
				for (int e = 0; e < array.length; e++) {
					score += array[e];
					
				}
				break;
			}
		}
		
		return score;
	}
}

