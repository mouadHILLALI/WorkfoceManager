package workforcemanger.workforce;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello daali!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
request.setAttribute("message", message);
request.getRequestDispatcher("index.jsp").forward(request , response);
    }

    public void destroy() {
    }
}
