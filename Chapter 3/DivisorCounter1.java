public class DivisorCounter1 {
	
	public static void main(String[] args) {
		System.out.print("Enter in max number: ");
		int maxNumberToCheck = TextIO.getlnInt();
		int maxDivisors = 0;

		for(int currentNumber = 1; currentNumber <= maxNumberToCheck; currentNumber++) { 
			int numDivisorsForThisNumber = 0;
			//System.out.println("**CurrentNumber: " + currentNumber);
			for(int j = 1; j <= currentNumber; j++) { 
				if(currentNumber % j == 0) {
					//System.out.println("Found a divisor: " + j);
					numDivisorsForThisNumber++;
				}			
			}
			// We've reached the end for this number.  Check to see if it has max divisors
			if(numDivisorsForThisNumber > maxDivisors)
				maxDivisors = numDivisorsForThisNumber;
		}
		
		//We will find a way to avoid this extra loop soon!
		System.out.println("The max # of divisors is: " + maxDivisors);
		System.out.print("The numbers that have that many are: ");
		
		for(int i = 1; i <= maxNumberToCheck; i++) { //for each number
			int numDivisorsForThisNumber = 0;

			for(int j = 1; j <= i; j++) { //AGAIN, check its divisors
				if(i % j == 0)
					numDivisorsForThisNumber++;
			}
			
			if(numDivisorsForThisNumber == maxDivisors) 
				System.out.print(i + " ");  
		}
	}
	
	
	
}
