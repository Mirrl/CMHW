import java.util.Scanner;

public class PrettyHeader {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);

        String msg = SafeInput.getNonZeroLenString(pipe, "Enter message for header");

        SafeInput.prettyHeader(msg);
    }
}
