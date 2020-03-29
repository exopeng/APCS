
public class CommandLineGradebook {
	public static void main(String[] args) {
		System.out.println("***Welcome to the Test Score Averager***");
		if(args.length == 0)
			System.out.println("Enter in test scores (as a decimal) on the command line!"
					+ " \nWe are old school here!");
		else {
			System.out.println("The average score is: ");
			System.out.println(Statistics.calculateAverage(args));
			// Calculate the average based on command line arguments
		}
	}
}
