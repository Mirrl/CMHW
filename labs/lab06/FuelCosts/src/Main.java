import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String trash = "";
        boolean done = false;

        double gallons = 0;
        do {
            System.out.print("Enter gas tank capacity (gallons) as a decimal or integer: ");
            if (in.hasNextDouble()) {
                gallons = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter gas tank capacity (gallons) as an decimal or integer");
            }
        } while (!done);

        done = false;
        double efficiency = 0;
        do {
            System.out.print("Enter gas efficiency (MPG) as a decimal or integer: ");
            if (in.hasNextDouble()) {
                efficiency = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter gas efficiency (MPG) as an decimal or integer");
            }
        } while (!done);

        done = false;
        double pricePerGallon = 0;
        do {
            System.out.print("Enter gas price (per gallon) as a decimal or integer: ");
            if (in.hasNextDouble()) {
                pricePerGallon = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter gas price (per gallon) as an decimal or integer");
            }
        } while (!done);

        double gallonsConsumed = 100 / efficiency;
        double tripCost = gallonsConsumed * pricePerGallon;

        System.out.println("For a 100 mile trip the car will consume " + gallonsConsumed + " gallons which will cost $" + tripCost + " to refuel" );

        double maxRange = gallons * efficiency;
        System.out.println("The max range the car can go is " + maxRange + " miles");
    }
 }