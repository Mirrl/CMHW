import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
        double totalCost = 0.0;
        boolean hasMoreItems = true;
        Scanner pipe = new Scanner(System.in);

        while (hasMoreItems) {
            double itemPrice = SafeInput.getRangedDouble(pipe, "Enter the price of the item", 0.50, 10.00);
            totalCost += itemPrice;

            hasMoreItems = SafeInput.getYNConfirm(pipe, "Do you have more items? (Y/N)");
        }

        System.out.printf("Total cost: $%.2f%n", totalCost);
    }
}
