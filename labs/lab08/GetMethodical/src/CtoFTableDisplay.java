public class CtoFTableDisplay {
    public static double CtoF(double celcius) {
        return (celcius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        System.out.println("[ Celsius | Fahrenheit ]");
        for (int celsius = -100; celsius <= 100; celsius++) {
            double fahrenheit = CtoF(celsius);
            System.out.println("[ " + celsius + " C | " + fahrenheit + " F ]");
        }
    }
}
