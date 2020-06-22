public class ResultPrinter {
    private ResultPrinter() {
    }

    public static String metric(double millimeters, double centimeters, double meters) {
        return header()
                + "metry: " + meters + "<br/>"
                + "centymetry: " + centimeters + "<br/>"
                + "milimetry: " + millimeters;
    }

    public static String weight(double milligrams, double grams, double kilos) {
        return header()
                + "kilogramy: " + kilos + "<br/>"
                + "gramy: " + grams + "<br/>"
                + "miligramy: " + milligrams;
    }

    private static String header() {
        return "<h3>Podana wartość w przeliczeniu na: </h3>";
    }
}