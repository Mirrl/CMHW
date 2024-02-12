import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter the price of the item you want to know the salex tax for");

        double purchasePrice = inputScanner.nextDouble();

        double itemSaleTax = purchasePrice * 0.05;

        System.out.println("The tax is " + itemSaleTax + " which brings the total to " + (purchasePrice + itemSaleTax));


    }
}