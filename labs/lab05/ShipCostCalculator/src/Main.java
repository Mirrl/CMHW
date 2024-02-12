import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter item price");

        double itemPrice = inputScanner.nextDouble();

        double total = itemPrice;

        if (itemPrice >= 100) {
            System.out.println("Shipping is free");
        }
        else {
            double shippingCost = itemPrice * 0.02;
            System.out.println("Shipping cost: " + shippingCost);
            total += shippingCost;
        }

        System.out.println("Total cost: " + total);
    }
}