package org.examle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class Redirect extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "https://www.google.com/";
        if (req.getParameterMap().containsKey("q")) {
            String q = req.getParameterMap().get("q")[0];
            url = url + "search?q=" + q;
        }
        resp.sendRedirect(url);
    }
}
