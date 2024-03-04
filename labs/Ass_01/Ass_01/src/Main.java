import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean play = true;
        while (play) {
            String playA = "", playB = "";

            while (playA.isEmpty()) {
                System.out.println("Player A make a move (R/P/S)");
                if (scanner.hasNextLine()) {
                    playA = scanner.nextLine();

                    // check validity of play

                    if (!playA.equalsIgnoreCase("R") && !playA.equalsIgnoreCase("P") && !playA.equalsIgnoreCase("S")) {
                        System.out.println("Player A entered an invalid play!");
                        playA = "";
                    }
                }
            }

            while (playB.isEmpty()) {
                System.out.println("Player B make a move (R/P/S)");
                if (scanner.hasNextLine()) {
                    playB = scanner.nextLine();

                    // check validity of play

                    if (!playB.equalsIgnoreCase("R") && !playB.equalsIgnoreCase("P") && !playB.equalsIgnoreCase("S")) {
                        System.out.println("Player B entered an invalid play!");
                        playB = "";
                    }
                }
            }

            if (playA.equalsIgnoreCase("R")) {
                if (playB.equalsIgnoreCase("R")) {
                    System.out.println("Tie! RxR");
                }
                else if (playB.equalsIgnoreCase("P")) {
                    System.out.println("Player B wins! Paper eats Rock");
                }
                else if (playB.equalsIgnoreCase("S")) {
                    System.out.println("Player A wins! Rock breaks Scissors");
                }
                else {
                    System.out.println("Player B entered an invalid play!");
                }
            }
            else if (playA.equalsIgnoreCase("P")) {
                if (playB.equalsIgnoreCase("R")) {
                    System.out.println("Player A wins! Paper eats Rock");
                }
                else if (playB.equalsIgnoreCase("P")) {
                    System.out.println("Tie! PxP");
                }
                else if (playB.equalsIgnoreCase("S")) {
                    System.out.println("Player B wins! Scissors cuts Paper");
                }
                else {
                    System.out.println("Player B entered an invalid play!");
                }
            }
            else if (playA.equalsIgnoreCase("S")) {
                if (playB.equalsIgnoreCase("R")) {
                    System.out.println("Player B wins! Rock breaks Scissors");
                }
                else if (playB.equalsIgnoreCase("P")) {
                    System.out.println("Player A wins! Scissors cuts Paper");
                }
                else if (playB.equalsIgnoreCase("S")) {
                    System.out.println("Tie! SxS");
                }
                else {
                    System.out.println("Player B entered an invalid play!");
                }
            }
            else {
                System.out.println("Player A entered an invalid play!");
            }

            System.out.println("Press N to terminate the game, otherwise press any key to continue.");

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("N")) {
                    play = false;
                }
            }
        }

        System.out.println("Game terminated. Thank you for playing!");
    }
}
