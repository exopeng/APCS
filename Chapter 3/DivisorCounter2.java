public class DivisorCounter2 {

	public static void main(String[] args) {
		System.out.print("Welcome, please enter a positive integer: ");
		int highestNumToCheck = TextIO.getInt();
		int numOfDivisors = findMaxNumOfDivisors(highestNumToCheck);
		String listOfIntsToReturn = listIntsWithAmountOfDivisors(highestNumToCheck, numOfDivisors);
		System.out.println("The number(s) between 1 and " + highestNumToCheck + " with the most divisors are: " + listOfIntsToReturn);
		System.out.println("They each have " + numOfDivisors + " divisors.");
	}
	
	public static int findMaxNumOfDivisors(int highestNumToTest) {
		int divisorCount = 0;
		int highestDivisorCount = 0;
		for (int num=1; num <= highestNumToTest; num++) {
			divisorCount = countDivisors(num); 
			if (divisorCount > highestDivisorCount){
				highestDivisorCount = divisorCount;
			}			   
		}
		return highestDivisorCount;
	}
	
	public static String listIntsWithAmountOfDivisors(int highestNumToTest, int divisorAmount) {
		String listOfIntsWithGivenAmountOfDivisors = "";
		for (int numToTest=1; numToTest<= highestNumToTest; numToTest++) {
			if (countDivisors(numToTest) == divisorAmount) { 
				listOfIntsWithGivenAmountOfDivisors += numToTest + " ";
			}
		}
		return listOfIntsWithGivenAmountOfDivisors; //return a String (we are NOT using System.out.println inside this subroutine)
	}
		
	public static int countDivisors(int num) {
		int divisorCount = 0;
		// Can you understand WHY we can stop at the sqrt of the num??
		for (int testDivisor=1; testDivisor < Math.sqrt(num); testDivisor++) {
			if ( num % testDivisor == 0 ){
				divisorCount += 2;
			}	
		 }
		if (Math.sqrt(num) == (int) Math.sqrt(num)) {
			divisorCount++;
		}
		return divisorCount;
	}
			   
}
