import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean play = true; // as long as this is true the main loop of the game will continue

        char player = 'A';

        Random random = new Random();

        while (play) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;

            int roll = die1 + die2;

            System.out.println("You rolled: " + roll);

            if (roll == 7 || roll == 11) {
                System.out.println("Rolled natural! You win!");
            } else if (roll == 2 || roll == 3 || roll == 12) {
                System.out.println("Craps! You lose!");
            } else {
                System.out.println("Trying for point: " + roll);
                int point = roll;
                boolean pointOver = false; // could use 'break;' instead but... this will just exit out of the point roll loop
                while (!pointOver) {
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    roll = die1 + die2;
                    System.out.print("\nYou rolled: " + roll);
                    if (roll == point) { // point = new target
                        System.out.println(" => Rolled point! You win");
                        pointOver = true;
                    } else if (roll == 7) { // 7 before point = lose
                        System.out.println(" => Rolled 7 before point, you lose!");
                        pointOver = true;
                    }
                }
            }

            if (player == 'A') { // prompt player B to play
                player = 'B';
            }
            else {
                player = 'A'; // prompt player A to play
            }

            System.out.println("Do you want to play another game as player " + player + "?" + " y for yes anything else for no");
            String promptAns = scanner.nextLine();

            if (!promptAns.equalsIgnoreCase("y")) {
                play = false;
            }
        }
    }
}
