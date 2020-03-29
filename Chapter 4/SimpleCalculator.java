// Task #1 Practice: Refactor code that is all ‘stuffed’ into main()
// Define and call at least 2 subroutines that would help the program to be more understandable and re-usable.
// They should be MEANINGFUL not just like public static void printTitle() { System.out.println("**Simple Calculator**"); }
// They should produce (almost) the same output and behavior* as the original, 'stuffed main()' version
// 	*There is ONE boo-boo in the calculations...find it and fix it.
public class SimpleCalculator {

    public static void main(String[] args) {

        System.out.println("**Simple Calculator**");

        System.out.println("Here are your options:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Division");
        System.out.println("4. Multiplication");

        int choice = getChoice();
        

        System.out.println(calculator(choice));
    }
    private static String calculator(int choice) {
	    int numOne, numTwo;
	    
	    System.out.print("First Number: ");
	    numOne = TextIO.getlnInt();
	
	    System.out.print("Second Number: ");
	    numTwo = TextIO.getlnInt();
	    String operation = "";
	    double answer = 0;
	    if (choice == 1) {
	    	operation = "+";
	    	answer = numOne + numTwo;
	    } else if (choice == 2) {
	    	operation = "-";
	    	answer = numOne - numTwo;
	    } else if (choice == 3) {
	    	operation = "/";
	    	answer = (double)numOne / numTwo;
	    } else {
	    	operation = "*";
	    	answer = numOne * numTwo;
	    }
	    
	    
	    return ("Result: " + numOne + " " + operation + " " + numTwo + " = " + (answer));
    }
    private static int getChoice() {
    	int choice = 0;
    	do {
        	System.out.print("What would you like to do?: ");
        	choice = TextIO.getlnInt();
        	
        	System.out.println();
        } while(choice != 1 && choice != 2 && choice != 3 && choice != 4);
    	return choice; 
    }
}
