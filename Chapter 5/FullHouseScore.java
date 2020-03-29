public class FullHouseScore extends Score {

	public FullHouseScore() {
		setName("FullHouse");
	}
	
	public int calculateScore(YahtzeeDice dice) {	
		int[] array = dice.getDiceValues();
		int[] countArray = getTallies(array);
		boolean has2 = false;
		boolean has3 = false;
		for (int i = 0; i < array.length; i++) {
			if (countArray[i] == 2) {
				has2 = true;
			}
			if (countArray[i] == 3) {
				has3 = true;
			}
		}
		
		if (has2 && has3) {
			return 25;
		} 
		
		return 0;
	} 
}
