import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter party affiliation");

        String party = inputScanner.nextLine();

        String result = "Other";

        if (party.equals("Independent")) {
            result = "Person";
        }
        else if (party.equals("Democrat")) {
            result = "Donkey";
        }
        else if (party.equals("Republican")) {
            result = "Elephant";
        }

        System.out.println("You get: " + result);
    }
}