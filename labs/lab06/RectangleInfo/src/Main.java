import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the lengths of both sides of the rectangle");
        String trash = "";
        boolean done = false;

        double firstSide = 0;
        do {
            System.out.print("Enter the first side's length as a decimal or integer: ");
            if (in.hasNextDouble()) {
                firstSide = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter a decimal or integer");
            }
        } while (!done);

        done = false;
        double secondSide = 0;
        do {
            System.out.print("Enter the second side's lenghth as a decimal or integer: ");
            if (in.hasNextDouble()) {
                secondSide = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter a decimal or integer");
            }
        } while (!done);

        double perimeter = firstSide * 2 + secondSide * 2;
        double area = firstSide * secondSide;
        double diagHyp = Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2));
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
        System.out.println("Diagonal: " + diagHyp);
    }
}