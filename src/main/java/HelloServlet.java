import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="HelloServlet",
        urlPatterns = ""
)

public class HelloServlet extends HttpServlet {
    XmlMapper mapper = new XmlMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("LoginSide.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name= req.getParameter("text");
        String password= req.getParameter("Password");

        if (name.equals("bob") & password.equals("123")){
            resp.sendRedirect("StartSide.html");
        }
        else{
            resp.sendRedirect("LoginSide.html");

        }
    }
}

