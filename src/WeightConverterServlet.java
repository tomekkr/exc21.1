import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/weight-converter")
public class WeightConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String kilosString = request.getParameter("kilos");
        String gramsString = request.getParameter("grams");
        String milligramsString = request.getParameter("milligrams");

        boolean isKilosFieldEmpty = (kilosString.equals(""));
        boolean isGramsFieldEmpty = (gramsString.equals(""));
        boolean isMilligramsFieldEmpty = (milligramsString.equals(""));

        PrintWriter writer = response.getWriter();

        try {
            double milligrams;
            double grams;
            double kilos;
            if (isKilosFieldEmpty & isGramsFieldEmpty) {
                milligrams = Double.parseDouble(milligramsString);
                grams = Calculator.milligramsToGrams(milligrams);
                kilos = Calculator.milligramsToKilos(milligrams);
                writer.println(ResultPrinter.weight(milligrams, grams, kilos));
            } else if (isKilosFieldEmpty & isMilligramsFieldEmpty) {
                grams = Double.parseDouble(gramsString);
                milligrams = Calculator.gramsToMilligrams(grams);
                kilos = Calculator.gramsToKilos(grams);
                writer.println(ResultPrinter.weight(milligrams, grams, kilos));
            } else if (isGramsFieldEmpty & isMilligramsFieldEmpty) {
                kilos = Double.parseDouble(kilosString);
                milligrams = Calculator.kilosToMilligrams(kilos);
                grams = Calculator.kilosToGrams(kilos);
                writer.println(ResultPrinter.weight(milligrams, grams, kilos));
            } else {
                writer.println("Należy wypełnić tylko jedno pole.");
            }

        } catch (NumberFormatException e) {
            writer.println("Podano nieprawidłową wartość.");
        }
    }
}