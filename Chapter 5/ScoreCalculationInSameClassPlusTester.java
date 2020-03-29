import java.util.Arrays;

public class ScoreCalculationInSameClassPlusTester {

	public static void main(String[] args) {
		ScoreCalculationInSameClassPlusTester myTester = new ScoreCalculationInSameClassPlusTester();
		System.out.println("Testing Ones: " + myTester.getOnesScore(new int[]{1, 1, 3, 4, 5})); // should be 2
		System.out.println("Testing Twos: " + myTester.getTwosScore(new int[]{1, 1, 3, 4, 5})); // should be 0
		System.out.println("Testing Threes: " + myTester.getThreesScore(new int[]{1, 1, 3, 4, 5})); // should be 3
		System.out.println("Testing Fours: " + myTester.getFoursScore(new int[]{1, 1, 4, 4, 5})); // should be 8
		System.out.println("Testing Fives: " + myTester.getFivesScore(new int[]{1, 1, 3, 4, 5})); // should be 5
		System.out.println("Testing Sixes: " + myTester.getSixesScore(new int[]{6, 6, 6, 4, 5})); // should be 18
		
		System.out.println("Testing Three of a Kind: " + myTester.getThreeOfAKindScore(new int[]{3, 1, 3, 4, 3})); // should be 14
		System.out.println("Testing Four of a Kind: " + myTester.getFourOfAKindScore(new int[]{1, 1, 1, 1, 5})); // should be 9
		System.out.println("Testing Full House: " + myTester.getFullHouseScore(new int[]{1, 1, 1, 4, 4})); // should be 25
		System.out.println("Testing Small Straight: " + myTester.getSmallStraightScore(new int[]{1, 2, 4, 3, 1})); // should be 30
		System.out.println("Testing Large Straight: " + myTester.getLargeStraightScore(new int[]{1, 2, 3, 4, 5})); // should be 40
		System.out.println("Testing Yahtzee: " + myTester.getYahtzeeScore(new int[]{6, 6, 6, 6, 6})); // should be 50
		System.out.println("Testing Chance: " + myTester.getChanceScore(new int[]{1, 3, 6, 6, 5})); // should be 21
		
	}
	
	
	
	// Returns the sum of the "1's" in the int[]
	public int getOnesScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 1) {
				score++;
			}
		}
		return score;
	}

	// Returns the sum of the "2's" in the int[]
	public int getTwosScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 2) {
				score += 2;
			}
		}
		return score;
	}

	// Returns the sum of the "3's" in the int[]
	public int getThreesScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 3) {
				score += 3;
			}
		}
		return score;
	}

	// Returns the sum of the "4's" in the int[]
	public int getFoursScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 4) {
				score += 4;
			}
		}
		return score;
	}

	// Returns the sum of the "5's" in the int[]
	public int getFivesScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 5) {
				score += 5;
			}
		}
		return score;
	}

	// Returns the sum of the "6's" in the int[]
	public int getSixesScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 6) {
				score += 6;
			}
		}
		return score;
	}

	
	// [4, 4, 2, 6, 2] --> returns 0
	// if you do find 3 of a kind, the score would be the sum of all
	public int getThreeOfAKindScore(int[] values) {
		int score = 0;
		for (int i = 0; i < 3; i++) {
			int checkNum = values[i];
			int count = 1;
			for (int j = 0; j < values.length; j++) {
				if (j != i) {
					if (values[j] == checkNum) {
						count++;
					}
				}
			}
			if (count >= 3) {
				for (int e = 0; e < values.length; e++) {
					score += values[e];
					
				}
				break;
			}
		}
		
		return score;
	}

	// [5, 5, 2, 5, 5] --> returns 22 (sum of all, because 4 of a kind)
	// return 0 if no four of a kind
	public int getFourOfAKindScore(int[] values) {
		int score = 0;
		for (int i = 0; i < 4; i++) {
			int checkNum = values[i];
			int count = 1;
			for (int j = 0; j < values.length; j++) {
				if (j != i) {
					if (values[j] == checkNum) {
						count++;
					}
				}
				
			}
			if (count >= 4) {
				for (int e = 0; e < values.length; e++) {
					score += values[e];
					
				}
				break;
			}
		}
		
		return score;
	}


	
	// [4, 4, 4, 1, 1] --> returns 25 (Full House)
	// [4, 3, 2, 5, 1] --> returns 0 (no Full House)
	// having 3 of one kind and 2 of another signifies full house
	public int getFullHouseScore(int[] values) {
		int[] countArray = getTallies(values);
		boolean has2 = false;
		boolean has3 = false;
		for (int i = 0; i < values.length; i++) {
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


	// [1, 2, 3, 4, x] or [2, 3, 4, 5, x] or  [3, 4, 5, 6, x] --> return 30
	// anything else --> return 0
	public int getSmallStraightScore(int[] values) {
		int[] tallies = getTallies(values);
		Arrays.sort(values);
		
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
	
	
	// [1, 2, 3, 4, 5] or [2, 3, 4, 5, 6] --> return 40
	// anything else --> 0
	public int getLargeStraightScore(int[] values) {
		Arrays.sort(values);
		int[] tallies = getTallies(values);
		
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
	
	// always just returns the sum of the values
	public int getChanceScore(int[] values) {
		int score = 0;
		for (int i = 0; i < values.length; i++) {
			score += values[i];
		}
		return score;
	}
	
	// Five of a kind [1,1,1,1,1] or [2,2,2,2,2], etc --> return 50
	// else return 0
	public int getYahtzeeScore(int[] values) {
		int checkNum = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] != checkNum) {
				return 0;
			}
		}
		
		return 50;
	}
	
	public int[] getTallies(int[] array) {
		int[] newArray = new int[6];
		for (int i = 0; i < array.length; i++) {
			switch (array[i]) {
			case 1:
				newArray[0]++;
				break;
			case 2:
				newArray[1]++;
				break;
			case 3:
				newArray[2]++;
				break;	
			case 4:
				newArray[3]++;
				break;
			case 5:
				newArray[4]++;
				break;
			case 6:
				newArray[5]++;
			}
		}
		return newArray;
	}
	
	
}

	

