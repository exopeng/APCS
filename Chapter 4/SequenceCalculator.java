//******* Your name:            ***********
// Task #1: Refactor code that is all ‘stuffed’ into main()
// Define and call at least 2 subroutines that would help the program to be less repetitive, more understandable and more re-usable.
// They should be MEANINGFUL not just like public static void printTitle() { System.out.println("**Sequence Calculator**"); }
// They should produce the same output and behavior as the original version

// If your subroutines job is to calculate a value, remember it should NOT have any System.out.println's.  
// Rather, it should return the value let main() decide what to do with it.
// If your subroutines job is to print out something, then you MAY have a System.out.println
public class SequenceCalculator {

	public static void main(String[] args) {

		System.out.println("**Sequence Calculator**");
		System.out.println("1. Fibonacci Sequence (The n-th term is found by summing up the previous 2 terms.)");
		System.out.println("2. Triangle Sequence (The n-th term is the number of dots composing a triangle with n dots on a side.)");
		System.out.println("3. Lazy Caterer's Sequence (The n-th term is the max number of pieces a pizza can be cut into given n straight cuts.)");

		int choice = getChoice();
		
		System.out.print("What value of 'n' do you want to calculate: ");
		int n = TextIO.getlnInt();
		while (n <= 0) {
			System.out.print("The starting point must be positive. Please try again: ");
			n = TextIO.getlnInt();
		}
		
		System.out.println(whichSequence(choice, n));
	}
	private static String whichSequence(int choice, int n) {
		
		int result = 0;
		
		if (choice == 3  ) {
			result = (n*n + n + 2)/2; // Explicit formula for Lazy Caterer Sequence
		} else if (choice == 2) {
			result = n*(n+1)/2; // Explicit formula for Triangle Sequence
		} else {
			int[] fibonacci = new int[n];
			fibonacci[0] = 1;
			if(n > 1) {
				fibonacci[1] = 1;
			}
			int termsCounted = 2;

			while(termsCounted < n) { // Calculate Fibonacci sequence using recursive formula
				fibonacci[termsCounted] = fibonacci[termsCounted - 1] + fibonacci[termsCounted - 2];
				termsCounted++;
			}

			result = fibonacci[n - 1];
		}
		
		return ("At term number " + n + ", the number in the sequence is: " + result); 
	}
	private static int getChoice() {
		int choice = 0;
		do {
			System.out.print("Which sequence would you like to calculate? ");
			choice = TextIO.getlnInt();
		} while(choice != 1 && choice != 2 && choice != 3);
		
		return choice;
	}
}

