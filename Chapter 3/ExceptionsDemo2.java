
public class ExceptionsDemo2 {

	public static void main(String[] args) {

		// *** Runtime Exception #2 *** 
		// Print out name, one char per line
		// (Notice that this problem is silly and contrived, 
		// normally you should just write your loops to not go out of bounds)
		String name = "Quick brown fox"; // length is 16
		int count = 100;
		while(count > 0) {
			// generate random int from 1 - 16 (16 would be out of bounds)
			int randIndex = (int)(Math.random()*name.length()) + 1;
			try {
				System.out.println(name.charAt(randIndex));
				count--;
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Out of bounds");
				count--;
			}
			// charAt() throws an IndexOutOfBoundsException if illegal index


		}
		
		
	}
}
