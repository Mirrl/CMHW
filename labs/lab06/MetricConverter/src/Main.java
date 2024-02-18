import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String trash = "";
        boolean done = false;
        double meters = 0;
        do {
            System.out.print("Enter meters as a decimal or integer: ");
            if (in.hasNextDouble()) {
                meters = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter a decimal or integer");
            }
        } while (!done);

         double miles = meters / 1609.344;
         double feet = meters * 3.28;
         double inches = feet * 12;

         System.out.println(meters + " m is equivalent to:");
         System.out.println(miles + " mi");
         System.out.println(feet + "'");
         System.out.println(inches + "\"");
         System.out.print("Or " + Math.round(feet) + "'" + inches % 12 + "\"");
    }
}
