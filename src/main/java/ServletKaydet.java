import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/kaydet")
public class ServletKaydet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        String responseHeaderTanimi = "<html><head>";
        responseHeaderTanimi += "<meta http-equiv='Content-Type' content='text/html' charset=UTF-8'>";
        responseHeaderTanimi += "<title>Kayıt Sayfası</title>";
        try {
            out = res.getWriter();
            out.println(responseHeaderTanimi);
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("isim");
            name = name.trim();
            String sname = req.getParameter("soyisim");
            sname = sname.trim();

            String strCinsiyet = "";
            String cinsiyet = req.getParameter("cinsiyet");
            if (cinsiyet != null) {
                Integer intCinsiyet = Integer.parseInt(cinsiyet);
                if (intCinsiyet == 1)
                    strCinsiyet = "Erkek";
                else if (intCinsiyet == 2)
                    strCinsiyet = "Kadın";
                else if (intCinsiyet ==3)
                    strCinsiyet = "Uzayli";
            }
            String sinif = req.getParameter("sinif");
            out.println("<body>");
            out.println("<h1>Girilen Bilgiler</h1>");
            // İstek Bilgileri yazdiriliyor
            out.println("<p>İsim: " + name + "</p>");
            out.println("<p>Soyisim: " + sname + "</p>");
            out.println("<p>Cinsiyet: " + strCinsiyet + "</p>");
            out.println("<p>Sınıf: " + sinif + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }finally {
            if(out!=null)
                out.close();
        }
    }
}