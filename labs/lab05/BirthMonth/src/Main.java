import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter your birth month");

        int numBirthMonth = inputScanner.nextInt();

        if (numBirthMonth < 1 || numBirthMonth > 12) {
            System.out.println("You entered an incorrect month value: " + numBirthMonth);
        }
        else {
            System.out.println("Your birth month is: " + numBirthMonth);
        }
    }
}