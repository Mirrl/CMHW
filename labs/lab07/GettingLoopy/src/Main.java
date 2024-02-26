public class Main {
    /**
     * The main method is the entry point of the program.
     * It demonstrates various looping patterns using nested for loops.
     */
    public static void main(String[] args) {
        // Part 1

        // increment: 1, 0 to 30
        System.out.println("Counting up by 1");
        for (int i = 0; i <= 30; i++) {
            System.out.print(i + ' ');
        }

        // decrement: 1, 30 to 0
        System.out.println("\nCoutning down by 1");
        for (int i = 30; i > -1; i--) {
            System.out.print(i + ' ');
        }

        // increment 3, 0 to 18
        System.out.println("\nCounting up by 3");
        for (int i  = 0; i <= 18; i += 3) {
            System.out.print(i + ' ');
        }

        System.out.println("\nCoutning down by 2");
        for (int i = 10; i >= 0; i -= 2) {
            System.out.print(i + ' ');
        }

        // Part 2


        System.out.println("\n5.\n");

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println("\n6.\n");

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println("\n7.\n");

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println("\nExtra\n");

        // Extra Credit:

        int width = 10;
        int height = 25;

        System.out.println("Cool M size: (" + width + 'x' + height + ')');

        for (int i = 0; i < height; i++) {
            // Left leg
            for (int j = 0; j < width; j++) {
                System.out.print('*');
            }
            
            // Spacing before down step
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }

            // Down step
            for (int j = 0; j < width; j++) {
                System.out.print('*');
            }

            // Spacing from down step to inverse
            for (int j = 0; j < (height - i - 1) * 2; j++) {
                System.out.print(' ');
            }

            // Inverse steps
            for (int j = 0; j < width; j++) {
                System.out.print('*');
            }

            // Spacing from inverse steps to right leg
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }

            // Right leg
            for (int j = 0; j < width; j++) {
                System.out.print('*');
            }
            
            // Next line
            System.out.println();
        }
    }
}
