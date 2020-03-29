public class CountMaxDivisors {
	
	// Everything is in main() currently.  Without looking at the example from a couple weeks ago,
	// try to separate out the functionality that is being repeated over and over into 2 or 3 subroutines.
	// That way, main() can be very short (say 6 or 7 lines), and just call the subroutines and output the results
	public static void main(String[] args) {
		System.out.print("Welcome, please enter a positive integer: ");
		int highestNumToCheck = TextIO.getInt();


		// For each number from 0 up to and including the highest number to check, find # of divisors
		int maxDivisors = calculateMaxDivisor(highestNumToCheck);
		
		// Now that we know the # of max divisors, go back through all 
		// the numbers again and see which ones have that # of divisors
		// e.g. for highestNumToCheck of 20, the max # of divisors is 6.
		// So we loop through all numbers again, checking to see which
		// numbers have 6 divisors (in this case, 12, 18, and 20). 
		System.out.print("The number(s) between 1 and " + highestNumToCheck + " with the most divisors are: ");
		printMax(highestNumToCheck, maxDivisors);
	}
	
	//takes in int n and calculates the max # of divisors from 1 to n
	//returns max # of divisors
	private static int calculateMaxDivisor(int highNum) {
		int maxDivisors = 0;
		for(int currentNumber = 0; currentNumber <= highNum; currentNumber++) { 
			int numDivisorsForThisNumber = 0;
			numDivisorsForThisNumber = getMaxDivisor(currentNumber);
			// We've finished counting for this number.  
			// Check to see if its # of divisors is more than current max divisors
			if(numDivisorsForThisNumber > maxDivisors)
				maxDivisors = numDivisorsForThisNumber;
		}
		return maxDivisors;
	}
	
	private static void printMax(int highestNumToCheck, int maxDivisors) {
		for(int i = 0; i <= highestNumToCheck; i++) { //for each number
			int numDivisorsForThisNumber = 0;

			numDivisorsForThisNumber = getMaxDivisor(i);
			
			if(numDivisorsForThisNumber == maxDivisors) //if you are one of the max divisor numbers
				System.out.print(i + " ");  //output!
		}
		System.out.println();
		System.out.println("They each have " + maxDivisors + " divisors.");
	}
	
	private static int getMaxDivisor(int i) {
		int numDivisorsForThisNumber = 0;
		for(int j = 1; j <= i; j++) { //AGAIN, check its divisors
			if(i % j == 0)
				numDivisorsForThisNumber++;
		}
		return numDivisorsForThisNumber;
	}
	
}
