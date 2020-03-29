public class BinaryConverterDebug {

	public static void main(String[] args) {
		String binaryString;
		do {
			System.out.print("Enter your binary number (must be 1's and 0's only): ");
			binaryString = TextIO.getlnString(); 
		} while(!isBinary(binaryString));
	
		
		String decimalString = convert(binaryString);
		System.out.println("Decimal is: " + decimalString);
	}
	
	public static boolean isBinary(String binaryString) {
		System.out.println("**Toggle breakpoint here - right click on strip to left of line number");
		for(int i = 0; i < binaryString.length(); i++) {
			if(binaryString.charAt(i) != 0 && binaryString.charAt(i) != 1)
				return false;
		}
		return true;
	}
	
	public static String convert(String binaryString) {
		int decimal = 0; 
		System.out.println("**Toggle breakpoint here - right click on strip to left of line number");
		for(int i = 0; i < binaryString.length(); i++) {
			if(binaryString.charAt(i) == '1') {
				decimal = decimal + (int)Math.pow(2, i);
			}
		}
		
		return String.valueOf(decimal);
	}

}
