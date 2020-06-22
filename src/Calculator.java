public class Calculator {
    private Calculator() {
    }

    public static double metersToCentimeters(double meters) {
        return meters * 100;
    }

    public static double metersToMilliimeters(double meters) {
        return meters * 1000;
    }

    public static double centimetersToMeters(double centimeters) {
        return centimeters / 100;
    }

    public static double centimetersToMillimeters(double centimeters) {
        return centimeters * 10;
    }

    public static double millimetersToCentimeters(double millimeters) {
        return millimeters / 10;
    }

    public static double millimetersToMeters(double millimeters) {
        return millimeters / 1000;
    }

    public static double kilosToGrams(double kilos) {
        return kilos * 1000;
    }

    public static double kilosToMilligrams(double kilos) {
        return kilos * 1_000_000;
    }

    public static double gramsToKilos(double grams) {
        return grams / 1000;
    }

    public static double gramsToMilligrams(double grams) {
        return grams * 1000;
    }

    public static double milligramsToKilos(double milligrams) {
        return milligrams / 1_000_000;
    }

    public static double milligramsToGrams(double milligrams) {
        return milligrams / 1000;
    }
}