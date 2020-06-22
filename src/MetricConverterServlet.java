import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/metric-converter")
public class MetricConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String metersString = request.getParameter("meters");
        String centimetersString = request.getParameter("centimeters");
        String millimetersString = request.getParameter("millimeters");

        boolean isMetersFieldEmpty = (metersString.equals(""));
        boolean isMilliMmtersFieldEmpty = (millimetersString.equals(""));
        boolean isCentimetersFieldEmpty = (centimetersString.equals(""));

        PrintWriter writer = response.getWriter();

        try {
            double millimeters;
            double centimeters;
            double meters;
            if (isMetersFieldEmpty & isCentimetersFieldEmpty) {
                millimeters = Double.parseDouble(millimetersString);
                centimeters = Calculator.millimetersToCentimeters(millimeters);
                meters = Calculator.millimetersToMeters(millimeters);
                writer.println(ResultPrinter.metric(millimeters, centimeters, meters));
            } else if (isMetersFieldEmpty & isMilliMmtersFieldEmpty) {
                centimeters = Double.parseDouble(centimetersString);
                millimeters = Calculator.centimetersToMillimeters(centimeters);
                meters = Calculator.centimetersToMeters(centimeters);
                writer.println(ResultPrinter.metric(millimeters, centimeters, meters));
            } else if (isCentimetersFieldEmpty & isMilliMmtersFieldEmpty) {
                meters = Double.parseDouble(metersString);
                millimeters = Calculator.metersToMilliimeters(meters);
                centimeters = Calculator.metersToCentimeters(meters);
                writer.println(ResultPrinter.metric(millimeters, centimeters, meters));
            } else {
                writer.println("Należy wypełnić tylko jedno pole.");
            }
        } catch (NumberFormatException e) {
            writer.println("Podano nieprawidłową wartość.");
        }
    }
}