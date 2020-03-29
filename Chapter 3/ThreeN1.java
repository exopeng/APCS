/**  
 * This program prints out a 3N+1 sequence starting from a positive 
 * integer specified by the user.  It also counts the number of 
 * terms in the sequence, and prints out that number.
 */
public class ThreeN1 {

    public static void main(String[] args) {                
        System.out.print("Which number: ");
        int userinput = TextIO.getlnInt();
        int n = 1;       // for computing terms in the sequence
        int counter = 0; // for counting the terms
        int max = 0;
        int max1 = 0;
        int new1 = userinput;

        while (userinput > 1) {
	        while (n > 1) {
	        	System.out.println(n);
	        	if ( n % 2 == 0) {
	        		n /= 2;
	        	} else {
	        		n = n * 3 + 1;
	        	}
	        	counter++;
	        }
	        if (counter > max) {
	        	max = counter;
	        	max1 = n;
	        }
	        
	        userinput--;
	        
	    }
    
 

        System.out.println("Longest sequence possible from 1 - " + new1 + " generated by number " + max1 + " Length of sequence:"+ max);

    }  // end of main()

}  // end of class ThreeN1