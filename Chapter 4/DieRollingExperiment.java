import java.util.Arrays;

public class DieRollingExperiment {
	public static void main(String[] args) {
		int numRolls = 100;
		int[] rolls = new int[numRolls];
		for (int i = 0; i < rolls.length; i++) {
			rolls[i] = (int)(Math.random() * 6 + 1);
		}
		System.out.println("A dice has been rolled " + numRolls + " times.");
		System.out.println("Here are the results: " + Arrays.toString(rolls));
		System.out.println("The average roll was a: "); //calculate average
		System.out.println(Statistics.calculateAverage(rolls));
		
	}
}
