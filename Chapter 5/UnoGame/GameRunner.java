
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many players in the game of uno?");
		UnoGame game = new UnoGame(Integer.parseInt(scanner.nextLine()));
		game.playGame();

	}

}
