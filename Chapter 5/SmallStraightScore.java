import java.util.Arrays;

public class SmallStraightScore extends Score  {
	
	public SmallStraightScore() {
		setName("SmallStraight");
	}
	
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int[] tallies = getTallies(array);
		Arrays.sort(array);
		
		//checks if a straight of 1-4
		for (int i = 0; i < tallies.length - 1; i++) {
			if (tallies[i] == 0) {
				break;
			}
			if (i == 3) {
				return 30;
			}
		}
		
		//checks a straight of 2-5
		for (int i = 1; i < tallies.length; i++) {
			if (tallies[i] == 0) {
				break;
			}
			if (i == 4) {
				return 30;
			}
		}
		
		//checks a straight of 3-6
		for (int i = 2; i < tallies.length; i++) {
			if (tallies[i] == 0) {
				break;
			}
			if (i == 5) {
				return 30;
			}
		}
		//for (int i = 1; i < array.length - 1; i++) {
		//	if (!(array[i] - 1 == array[i - 1])) {
		//		return 0;
		//	}
		//}
		return 0;
	}
}
