import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);

        // Get SSN from user
        String ssn = SafeInput.getRegExString(pipe,"\"Enter SSN (XXX-XX-XXXX)", "^\\d{3}-\\d{2}-\\d{4}$");
        String mNumber = SafeInput.getRegExString(pipe,"Enter UC Student M number (MXXXXX)", "^(M|m)\\d{8}$"); // Instructions say 5 but an M number is 8 in length? I am going with 8, hopefully this is the right call!
        String menuChoice = SafeInput.getRegExString(pipe, "Enter menu choice (O, S, V, Q)", "^[OoSsVvQq]$");

        // Rest of the code...
    }
}
