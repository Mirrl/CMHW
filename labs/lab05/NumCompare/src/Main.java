import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter 2 numbers");

        if (inputScanner.hasNextInt()) {
            int number1 = inputScanner.nextInt();

            if (inputScanner.hasNextInt()) {
                int number2 = inputScanner.nextInt();

                if (number1 == number2) {
                    System.out.println("Both numbers are equal (" + number1 + ")");
                }
                else if (number1 < number2) {
                    System.out.print("Number1 (" + number1 + ")" + " is smaller than Number2 (" + number2 + ")");
                } else {
                    System.out.println("Number2 is smaller than Number1 (" + number2 + ")");
                }
            } else {
                System.out.println("Second input was invalid, enter a number!");
            }

        } else {
            System.out.println("First input was invalid, enter a number!");
        }
    }
}