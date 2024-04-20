import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": ");

            retString = pipe.nextLine();

            if (retString.length() == 0) {
                System.out.println("Input cannot be empty!");
            }

        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        boolean read = false;

        System.out.print("\n" + prompt + ": ");

        int value = 0;
        while (!read) {
            if (pipe.hasNextInt()) {
                read = true;
                value = pipe.nextInt();
            } else {
                System.out.println("Invalid input: (" + pipe.nextLine() + ") Enter an integer");
            }
        }

        return value;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean read = false;

        System.out.print("\n" + prompt + ": ");

        int value = 0;
        while (!read) {
            if (pipe.hasNextLine()) {
                if (pipe.hasNextInt()) {
                    value = pipe.nextInt(); // Call nextInt regardless of input validity to consume the buffer
                    if (value < low) {
                        System.out.println("Invalid input: Number cannot be lower than " + low);
                    } else if (value > high) {
                        System.out.println("Invalid input: Number cannot be higher than " + high);
                    } else {
                        read = true;
                    }
                } else {
                    System.out.println("Invalid input: (" + pipe.nextLine() + "), Enter an integer");
                }
            }
        }

        return value;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        boolean read = false;

        System.out.print("\n" + prompt + ": ");

        double value = 0;
        while (!read) {
            if (pipe.hasNextDouble()) {
                read = true;
                value = pipe.nextDouble();
            } else {
                System.out.println("Invalid input: (" + pipe.nextLine() + ") Enter a double");
            }
        }

        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean read = false;

        System.out.print("\n" + prompt + ": ");

        double value = 0;
        while (!read) {
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble(); // Call nextInt regardless of input validity to consume the buffer
                if (value < low) {
                    System.out.println("Invalid input: Number cannot be lower than " + low);
                } else if (value > high) {
                    System.out.println("Invalid input: Number cannot be higher than " + high);
                } else {
                    read = true;
                }
            } else {
                System.out.println("Invalid input: (" + pipe.nextLine() + "), Enter a double");
            }
        }

        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean read = false;

        System.out.print("\n" + prompt + ": ");

        String value = "";
        while (!read) {
            if (pipe.hasNextLine()) {
                value = pipe.nextLine(); // Read regardless to consume buffer
                if (!value.equalsIgnoreCase("y") && !value.equalsIgnoreCase("n")) {
                    System.out.println("Invalid input: (" + value + ") Enter Y or N");
                } else {
                    read = true;
                }
            }
        }

        return value.equalsIgnoreCase("Y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean found = false;

        String haystack = "";
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextLine()) {
                haystack = pipe.nextLine();

                if (haystack.matches(regEx)) {
                    found = true;
                } else {
                    System.out.println("Invalid input! Could not find match in: " + haystack);
                }
            }
        } while (!found);

        return haystack;
    }

    public static void prettyHeader(String msg) {
        int headerW = 60; // Width of header in character length (asterisks included)
        int msgW = msg.length(); // width in character length
        int starsWidth = (headerW - msgW - 6) / 2; // / 2 for each side... 3 for each asterisk

        // Top line
        for (int i = 0; i < headerW; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Message and surrounding
        System.out.print("***");
        for (int i = 0; i < starsWidth; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < starsWidth; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Bottom Line
        for (int i = 0; i < headerW; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
