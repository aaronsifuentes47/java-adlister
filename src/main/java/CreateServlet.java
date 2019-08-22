import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/create")
public class CreateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/ads/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ads adsDao = DaoFactory.getAdsDao();
        // create a new Ad based on the submitted data
        String title = request.getParameter("title");
        long id = request.getIntHeader("id");
        long price = Long.parseLong(request.getParameter("price"));
        String description = request.getParameter("description");
        Ad Ad = new Ad(id,price,title,description);
        // persist the new product
        adsDao.insert(Ad);
        response.sendRedirect("/ads");
    }


}
