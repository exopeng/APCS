import java.io.*;

public class ExceptionsDemo {

	public static void main(String[] args) {
		// *** Runtime Exception #1 *** 
		// parseInt() throws a NumberFormatException if wrong format
		System.out.println("Trying to turn Strings \"3\" and \"pizza\" to ints");
		try {
			int num1 = Integer.parseInt("3"); 
			System.out.println("Num1 is: " + num1);
			int num2 = Integer.parseInt("pizza"); 
			System.out.println("Num2 is: " + num2);
		}
		catch(NumberFormatException e) {
			System.out.println("error while parsing");
		}
		
		
		// *** Runtime Exception #2 *** 
		// Print out name, one char per line
		
		
		// *** Compile Time (Checked) Exception #1 *** 
		// Checked Exceptions are checked at compile time
		// In other words, you can't even run the program until you specify how
		// you will handle certain potential problems
		
		try {
		FileReader reader = new FileReader("test.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
	
	
}
