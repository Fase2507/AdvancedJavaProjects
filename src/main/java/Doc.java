import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Fatih SEVER
 */
@WebServlet("/doc") // This maps the servlet to http://localhost:8080/AdvanceJavaMvn/doc
public class Doc extends HttpServlet {
    private String dosyaYolu;
    private Long dosyaBoyutu;

    // Standard constructor for Servlet container
    public Doc() {}

    public Doc (String dosyaYolu, Long dosyaBoyutu){
        this.dosyaBoyutu = dosyaBoyutu;
        this.dosyaYolu = dosyaYolu;
    }

    public String oku(String text){
        return "%s".formatted(text);
    }
    public String oku(){
        try{
            return Files.readString(Paths.get(this.dosyaYolu));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: couldn't see file at"+this.dosyaYolu;
        }
    }
    // This handles the browser request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String icerik = oku("Servlet is running");

        // Set response type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Doc Servlet Output</h1>");
        out.println("<p>Content: <b><mark>" + icerik + "</mark></b></p>");
        out.println("</body></html>");
    }
}