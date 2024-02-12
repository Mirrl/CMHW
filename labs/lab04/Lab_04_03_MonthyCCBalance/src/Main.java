//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double interestRate = 0.17;
        double creditCardBalance = 5000;


        for (int i = 1; i <= 2; i++) { // Starts at 1 for the print statement to make sense.
            double interest = creditCardBalance * interestRate;

            creditCardBalance += interest;

            System.out.println("Balance after " + i + " months: " + creditCardBalance);
        }
    }
}