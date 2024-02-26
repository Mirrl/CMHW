import java.util.Scanner;

public class FtoC {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        boolean valid = false; // valid input flag
        double temperatureF = 0.f;
        do {
            System.out.println("Enter temperature in F");
            if (inputScanner.hasNextDouble()) {
                temperatureF = inputScanner.nextDouble();
                valid = true;
            }
            else {
                // Need to call nextLine to consume current input buffer (invalid in this case)
                System.out.println("Error: invalid input (" + inputScanner.nextLine() + ") is not a number");
            }
        } while(!valid);

        // C = (F - 32) / 1.8 <----> (9/5) = 1.8
        double temperatureC = (temperatureF - 32) / (9.0/5.0);

        System.out.println(temperatureF + " Fahrenheit is equal to " + temperatureC + " Celsius");
    }
}
