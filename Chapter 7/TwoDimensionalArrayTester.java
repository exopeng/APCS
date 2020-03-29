public class TwoDimensionalArrayTester {
	public static void main(String[] args) {
		int[][] twoByThree = new int[][] {{1,2,3}, {4,5,6}};
		int[][] threeByThree = new int[3][3];
		int[][] fourByFive = new int[4][5];
		
		for (int i = 0; i < fourByFive.length; i++) {
			System.out.println(java.util.Arrays.toString(fourByFive[i])); 

		}
		
		// Test countZeros method
		System.out.println("Zeros: " + countZeros(fourByFive));
		
		// Call fill1And3() method
		fill1And3(fourByFive);
		
		// Print out array, see if fill1And3() actually changed anything

		
		// Check if countZeros() properly detects the lack of 0's
		System.out.println("Zeros: " + countZeros(fourByFive));
		
	}
	
	// Fills a 2-dimensional array of integers with 1's, 
	// except where the row number is the same as the column number
	// -- fill those with 3's 
	public static void fill1And3(int[][] vals){
		for (int i = 0; i < vals.length; i++) {
			for (int j = 0; j < vals[0].length; j++) {
				if (i != j) {
					vals[i][j] = 1;
				} else {
					vals[i][j] = 3;

				}
			}
		}
	}
	
	
	public static int countZeros(int[][] vals) {
		int counter = 0;
		for (int i = 0; i < vals.length; i++) {
			for (int j = 0; j < vals[0].length; j++) {
				if (vals[i][j] == 0) {
					counter++;
				}
			}
		}
		
		return counter;
	}

	
}
