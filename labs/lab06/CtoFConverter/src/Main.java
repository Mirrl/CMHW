import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double celcius = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("Enter Celcius temperature as number: ");
            if (in.hasNextDouble()) {
                celcius = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("\nYou entered " + trash);
                System.out.println("You have to enter a your temperature in celcius as a number");
            }
        } while (!done);

        double fahrenheit = celcius * 9/5 + 32;

        System.out.println(celcius + "C is equivalent to " + fahrenheit + "F");
    }
}