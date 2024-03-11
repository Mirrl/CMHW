import java.util.Scanner;

public class FavNumbers {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        double favDouble = SafeInput.getDouble(pipe, "Enter your favorite double");
        int favInt = SafeInput.getInt(pipe, "Enter your favorite integer");

        System.out.println("You entered: " + favDouble + " as your favorite double and " + favInt + " as your favorite integer");
    }
}
