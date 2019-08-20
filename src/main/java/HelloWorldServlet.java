import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet({"/", "/somewhere"})
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String cohort = req.getParameter("cohort");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h1>Hello, " + cohort + "!</h1>");



    }
}
