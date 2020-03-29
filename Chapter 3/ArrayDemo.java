
public class ArrayDemo {

	public static void main(String[] args) {
		
		// Declare and create an array of ints, of length 10.  
		int[] myArray = new int[10];

		// Initially, they are full of 0's.  
		// Let's populate half of it with random ints from 0 - 99. 		
		for(int i = 0; i < myArray.length / 2; i++) {
			myArray[i] = (int)(Math.random()*100);
		}
		
		// Here is an example of how to create an int array, and populate
		// it with values, right from the very beginning.  
		// This is an alternative to: myArray[0] = 4; myArray[1] = 8; myArray[2] = 15; ...etc
		int[] myArray2 = new int[] {4,8,15,16,23,42};
		
		System.out.println(myArray); // Will NOT print out the contents properly
		
		for(int i = 0; i < myArray.length; i++) // This will. 
			System.out.print(myArray[i] + ", ");
		System.out.println();
		
		System.out.println("******* Finding max value in myArray: " + findMax(myArray));
		System.out.println("******* Finding average of myArray (not counting 0's): " + findAvg(myArray, false));
		System.out.println("******* Finding average of myArray (counting 0's): " + findAvg(myArray, true));

	}
	
	// Finds the maximum value in the int[], and returns it. 
	// Example: findMax([2, 4, 9, 2, 0, -4]) --> 9
	public static int findMax(int[] myList) {
		int max = myList[0];
		for (int i = 1; i < myList.length; i++) {
			if (myList[i] > max) {
				max = myList[i];
			}
		}
		return max;
	}
	
	// Finds the average value of the int[], and returns it. 
	// If the boolean countZeros is true, we include the zeros in the average
	// If not, we skip over the zeros in calculating our average. 
	// Example: findAvg([4, 5, 6, 0, 0, 0], true) --> 15/6 --> 2.5
	// Example: findAvg([4, 5, 6, 0, 0, 0], false) --> 15/3 --> 5.0
	public static double findAvg(int[] myList, boolean countZeros) {
		double average = 0;
		if (countZeros) {
			for (int i = 0; i < myList.length; i++) {
				average+= myList[i];
			}
			average /= myList.length;
		} else {
			double counter = 0;
			for (int i = 0; i < myList.length; i++) {
				if (!(myList[i] == 0)) {
					counter++;
					average += myList[i];
				}
			}
			average /= counter;
				
		}
		return average;
	}	
	
	
}
