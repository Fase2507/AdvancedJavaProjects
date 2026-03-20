import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/home")
public class HomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;

        String resHeader = "<!DOCTYPE html>";
        resHeader += "<html><head>";
        resHeader += "<meta http-equiv='Content-Type' content='text/html' charset='UTF-8'";
        resHeader += "<title>Servlet'den Merhaba!</title>";
        resHeader += "</head>";

        try{
            out = res.getWriter();
            out.println("<body>");
            out.println("<h1 style='color: red;'>HOME</h1>");

            out.println("<h1 style='color: red;'>Hellow WORLD</h1>");
            HttpSession session = req.getSession();
            out.println("<p>Bağlantı Adresi: <strong>" + req.getRemoteAddr() + "</strong></p>");
            out.println("<p>İstek URI: <strong>" + req.getRequestURI() + "</strong></p>");
            out.println("<p>Protokol: <strong>" + req.getProtocol() + "</strong></p>");
            out.println("<p>İstek Metodu: <strong>" + req.getMethod() + "</strong></p>");
            out.println("<p>Session Id: <strong>" + session.getId() + "</strong></p>");

            out.println("<p>Session Oluşturulma Zamanı: <strong>"
                    + convertTime(session.getCreationTime()) + "</strong></p>");
            out.println("<p>Session Son İstek Zamanı: <strong>"
                    + convertTime(session.getLastAccessedTime()) + "</strong></p>");
            out.println("<p>Session Yeni Mi?: <strong>"
                    + (session.isNew() ? "Evet" : "Hayır") + "</strong></p>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            if(out!=null)
                out.close();
        }
    }

    private String convertTime(long creationTime) {
        Date time = new Date(creationTime);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        return sdf.format(time);
    }
//    private String convertTime(long timeInMillis) {
//        // 1. Convert milliseconds to an Instant
//        Instant instant = Instant.ofEpochMilli(timeInMillis);
//
//        // 2. Convert Instant to a LocalDateTime (using your computer's system timezone)
//        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//
//        // 3. Create a pattern (Day-Month-Year Hour:Minute:Second)
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//
//        // 4. Return the formatted string
//        return dateTime.format(formatter);
//    }
}
