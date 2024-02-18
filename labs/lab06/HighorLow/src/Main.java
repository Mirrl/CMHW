import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        int targetvalue = gen.nextInt(10) + 1;

        String trash = "";
        boolean done = false;
        int guess = 0;

        do {
            System.out.print("Enter your guess: ");
            if (in.hasNextInt()) {
                guess = in.nextInt();
                in.nextLine();

                if (guess > 10 || guess < 1) {
                    System.out.println("Out of range! the range is [1, 10]");
                }
                else if (guess == targetvalue)
                    done = true;
                else if (guess < targetvalue) {
                    System.out.println("Wrong! try higher");
                } else {
                    System.out.println("Wrong! try lower");
                }
            } else {
                trash = in.nextLine();
                System.out.println("You entered " + trash);
                System.out.println("You have to enter a decimal or integer");
            }
        } while (!done);

        System.out.println("Nice! " + guess + " is correct");
    }
}
