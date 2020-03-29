import java.util.Arrays;

public class LargeStraightScore extends Score {
	
	public LargeStraightScore() {
		setName("LargeStraight");
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		Arrays.sort(array);
		int[] tallies = getTallies(array);
		
		//checks if a straight of 1-5
		for (int i = 0; i < tallies.length; i++) {
			if (tallies[i] == 0) {
				break;
			}
			if (i == 4) {
				return 40;
			}
		}
		
		//checks straight of 2-6
		for (int i = 1; i < tallies.length; i++) {
			if (tallies[i] == 0) {
				break;
			}
			if (i == 5) {
				return 40;
			}
		}
		
		
		//for (int i = 1; i < array.length; i++) {
		//	if (!(array[i] - 1 == array[i - 1])) {
		//		return 0;
		//	}
		//}
		return 0;
	} 
}
