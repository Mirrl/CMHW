import java.util.Random;
import java.util.Scanner;;

public class Main {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rnd = new Random();

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        for (int dataPoint : dataPoints) {
            System.out.print(dataPoint + " | ");
        }

        int sum = sum(dataPoints);
        double avg = getAverage(dataPoints); // this will loop again for no reason, logically should have just used 'sum' and divided that by the length of the array but part E asked to change this to its own method.

        System.out.println("\nThe sum of the random data points is " + sum + "\nWith the average random value being " + avg);

        Scanner scanner = new Scanner(System.in);

        int searchTargetInput = SafeInput.getRangedInt(scanner, "Enter a target numeric integer value for lookup", 0, 100);

        boolean doesContainSearchTarget = contains(dataPoints, searchTargetInput);

        // I think this is how the assignment should be done, I understand there is no point in iterating over the array so many times like I do here when this could be all done in one pass. So I hope this is right...
        if (doesContainSearchTarget) {
            int firstInstanceIndex = findFirstInstanceIndex(dataPoints, searchTargetInput);
            System.out.println("The value " + searchTargetInput + " was found at index " + firstInstanceIndex);

            int occurrences = occurrenceScam(dataPoints, searchTargetInput);
            System.out.println("The value " + searchTargetInput + " appears in the array " + occurrences + " times");
        } else {
            System.out.println("The value " + searchTargetInput + " is not inside the array");
        }

        int min = min(dataPoints);
        int max = max(dataPoints);

        System.out.println("The min and max data points are (" + min + ", " + max + ") respectively");
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }

        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        return max;
    }

    public static int occurrenceScam(int[] values, int target) {
        int occurance = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                occurance++;
            }
        }

        return occurance;
    }

    public static int sum(int[] values) {
        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        return sum;
    }

    public static int findFirstInstanceIndex(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }

        return false;
    }

    public static double getAverage(int[] values) {
        return (double)sum(values) / values.length;
    }
}
