// Task #1 Practice: Refactor code that is all ‘stuffed’ into main()
// Define and call at least 2 subroutines that would help the program to be more understandable and re-usable.
// They should be MEANINGFUL not just like public static void printTitle() { System.out.println("***Welcome to the Simple Grader.***"); }
// They should produce the same output and behavior as the original, 'stuffed main()' version
public class SimpleSISGradebook {
	
	public static void main(String[] args) {
		
		String readFileName = "scores.txt";
		String writeFileName = "grades.txt";
		int numAssignments = 3;
		int numStudents = 5;
		
		// Text file (scores.txt) looks like:
		// 12121 72 75 93 
		// 11500 52 62 64 
		// 12893 72 56 72 
		// 10355 90 91 82 
		// ...					
		// Create a 2D array of ints to store the Student ID and assignment scores
		int[][] studentsScores = new int[numStudents][numAssignments + 1]; // Need one extra space for Student ID number
		
		System.out.println("***Welcome to the Simple Grader.***");
		System.out.println("--I will read in the file: " + readFileName);
		System.out.println("Inside the file is the ID of the students and their scores on the most recent " + numAssignments + " assignments.");
		try {
			System.out.println("--Reading file...");
			TextIO.readFile(readFileName);
			
			for(int i = 0; i < numStudents; i++) {
				studentsScores[i][0] = TextIO.getInt();
				for(int j = 0; j < numAssignments; j++) {
					studentsScores[i][j+1] = TextIO.getInt();
				}
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		System.out.println("**" + readFileName + " read.**");
		System.out.println("Now I will average the scores and output a letter grade.");
		System.out.println("I will write the results in a file called: "+ writeFileName);
		
		TextIO.writeFile(writeFileName);
		for(int i = 0; i < numStudents; i++) { // Go through each row in the 2D array
			TextIO.put(studentsScores[i][0]); // First, write the Student ID (the first element in each row)
			TextIO.put(" "); 
			
			int total = 0;
			total = summer(total, numAssignments, studentsScores, i);
			
			double average = total/(double)numAssignments;
			
			TextIO.put("Average: "); 
			TextIO.put(String.format("%.2f", average)); // Write the average score in the file
			TextIO.put(" "); 
			
			// Finally, write the letter grade, based on the average
			TextIO.put(writeLetter(average));
			TextIO.put("\n");
		}
		System.out.println("**" + writeFileName + " written.**");
 
	}		
	
	private static String writeLetter(double average) {

		if(average >= 90) {
			return "A"; 
		} else if(average >= 80) {
			return "B"; 
		} else if(average >= 70) {
			return "C";
		} else if(average >= 60) {
			return "D";
		} else {
			return "F";
		}

	}
	private static int summer(int total, int numAssignments, int[][] studentsScores, int i) {
		for(int j = 0; j < numAssignments; j++) {
			total += studentsScores[i][j + 1]; // Next, sum up the total points on assignments (needed for the average).
												// Start at index '1' because index '0' is the student ID
		}
		return total;
	}
		
}
	
	
	

