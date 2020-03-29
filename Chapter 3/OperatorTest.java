public class OperatorTest {
    public static void main(String[] args) {
		byte test = 100;
		System.out.println(test); 
		test = (byte)(test+20);  
		System.out.println(test); 
		test = (byte)(test+20);
		System.out.println(test); 
		
		
		int a = 12;
		int b = 8;
		int c = 6;
			
		// do some arithmetic
	
		// Test concatenation and assignment statements
		System.out.println(a + " " + b + " " + c + " ");  //12 8 6
		a = c;
		System.out.println(a + " " + b + " " + c + " "); //6 8 6
		c = c + b;
		System.out.println(a + " " + b + " " + c + " "); //6 8 14
		a = b + c;
		System.out.println(a + " " + b + " " + c + " "); //22 8 14
		
		//unary operators
		c = a++ + b++;   //a was 22 b was 8.  c = 22 + 8, then a = 23, b = 9
						//if switch to prefix, then c = 23 + 9 = 32
		System.out.println(a + " " + b + " " + c + "**"); 

		
		//what's wrong with this? what's going on here?
		int quotient;
		int x = 6;
		int y = 10;
		quotient = x / y; 
		System.out.println(quotient); 
		
		// let's try again! Note that the type conversion operator has higher
		//precedence than division. 
		
		
		
		// You can perform multiple boolean checks in one statement using 
		// "and" && or the "or" || operators
		boolean myBool = true;
		if(true && myBool && false)
			System.out.println("True!!!");
		else 
			System.out.println("False!!!");
		
		// Call subroutines defined below...remember they don't run unless
		// we call them!

		
	}
	
	public static void sayHi() {
		System.out.println("Hi");
	}
	
	public static void saySup() {
		System.out.println("Sup");
	}

}