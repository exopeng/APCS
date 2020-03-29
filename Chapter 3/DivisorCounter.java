import java.util.Scanner;

public class DivisorCounter{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("All the numbers until which number: ");
		int input = Integer.parseInt(scanner.nextLine());
		int maxDiv = 0;
		int divCount;

		for (int i = 1; i <= input; i++) {
			divCount = 0;
			for (int j = i; j > 0; j--) {
				if (i % j == 0) {
					divCount++;
				}
			}
			if (divCount > maxDiv) {
				maxDiv = divCount;
			} 
		}

		for (int i = 1; i <= input; i++) {
			divCount = 0;
			for (int j = i; j > 0; j--) {
				if (i % j == 0) {
					divCount++;
				}
			}
			if (divCount == maxDiv) {
				System.out.println();
				System.out.print(i + ":");
				for (int j = i; j > 0; j--) {
					if (i % j == 0) {
						System.out.print(" " + j);
					}
				}
			}
		}
		System.out.println();
		System.out.println("These numbers have " + maxDiv + " divisors");

	}
}