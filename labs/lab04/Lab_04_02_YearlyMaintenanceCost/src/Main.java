import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter the maintenance to each season when prompted and receive the total cost");

        System.out.println("Spring");
        double springPrice = inputScanner.nextDouble();

        System.out.println("Winter");
        double winterPrice = inputScanner.nextDouble();

        System.out.println("Summer");
        double summerPrice = inputScanner.nextDouble();

        System.out.println("Fall");
        double fallPrice = inputScanner.nextDouble();

        double annualTotal = springPrice + winterPrice + summerPrice + fallPrice;

        System.out.println("The total annual cost of maintenance is " + annualTotal);
    }
}