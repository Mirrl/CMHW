import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter your age");

        int age = inputScanner.nextInt();

        if (age >= 21) {
            System.out.println("You get a wrist band");
        }
    }
}