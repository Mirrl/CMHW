import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);

        int year = SafeInput.getRangedInt(pipe, "Enter your birth year [1950-2015]", 1950, 2015);

        int month = SafeInput.getRangedInt(pipe, "Enter your birth month [1-12]", 1, 12);

        int day = 0;
        switch (month) {
            case 2:
                if (year % 4 == 0) { // leap year
                    day = SafeInput.getRangedInt(pipe, "Enter your birth day [1-29]", 1, 29);
                } else {
                    day = SafeInput.getRangedInt(pipe, "Enter your birth day [1-28]", 1, 28);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = SafeInput.getRangedInt(pipe, "Enter your birth day [1-30]", 1, 30);
                break;
            default:
                day = SafeInput.getRangedInt(pipe, "Enter your birth day [1-31]", 1, 31);
        }

        System.out.println("Thank you! Your birth date is " + month + "/" + day + "/" + year);
    }
}
