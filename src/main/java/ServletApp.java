import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/files")
public class ServletApp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 1. Create an instance of your original Doc class
        Doc myDoc = new Doc("C:/Users/User/Desktop/test.txt", 1024L);
        String icerik = myDoc.oku();
        String icerik2 = new Doc().oku("something");
        // 2. Set response headers
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 3. Generate HTML output
        out.println("<html>");
        out.println("<head><title>File Viewer</title></head>");
        out.println("<body>");
        out.println("<h1>Java Servlet File System</h1>");
        out.println("<p>Reading content from Doc class...</p>");
        out.println("<div style='border:1px solid black; padding:10px; background:#f0f0f0;'>");
        out.println("<strong>Content:</strong> " + icerik2);
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}