import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/about")
public class ServletPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // 1. Correctly use your initialized object
        Doc myDoc = new Doc("C:/Users/User/Desktop/test.txt", 1024L);
        String icerik = myDoc.oku(); // Use the object that has the path!

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>File Viewer</title>");
        // Fixed the style tag typo here
        out.println("<style>body { background: #121212; color: white; font-family: Arial; padding: 20px; }</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Java Servlet File System</h1>");
        out.println("<div style='border:1px solid #444; padding:20px; background:#222; border-radius:10px;'>");
        out.println("<strong>File Content:</strong><br><pre>" + icerik + "</pre>");
        out.println("</div>");
        out.println("<br><a href='index.html' style='color: #007bff;'>Go Back</a>");
        out.println("<br><a href='kaydet.jsp' style='color: #007bff;'>Kaydet</a>");
        out.println("</body></html>");
    }
}
