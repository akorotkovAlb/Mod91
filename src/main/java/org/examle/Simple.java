package org.examle;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;


// for creating war file -> compiler:compile -> war:war
@WebServlet(value = "/simple")
public class Simple extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

//        // TODO set cookies to response use custom option
//        response.setHeader("Set-Cookie", "firstName=Andrii; lastName=Korotkov;");

//        // TODO set cookies to response use HttpServletResponse method
//        response.addCookie(new Cookie("firstName", "AndriiQwerty"));
//        response.addCookie(new Cookie("lastName", "Korotkov123456"));

//        // TODO create session if not exist
//        HttpSession session = request.getSession(true);
//        session.setAttribute("user", new User("Session", "User"));
//        session.setMaxInactiveInterval(10);
//        User sessionUser = (User) session.getAttribute("user");
//        System.out.println("firstName ---> " + sessionUser.getFirstName());
//        System.out.println("---->>> " + session.getId());

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h3>Hello World with New Servlet!</h3>");

//        // TODO get cookies from request use custom method
//        Map<String, String> customCookies = getCookies(request);
//        if (!customCookies.isEmpty()) {
//            customCookies.forEach((name, value) -> {
//                out.print("<p>1 - Cookie name = ${name}; Cookie value = ${value}</p>"
//                        .replace("${name}", name)
//                        .replace("${value}", value));
//            });
//        }

//        // TODO get cookies from request use HttpServletRequest method
//        Arrays.stream(request.getCookies()).toList().forEach(cookie -> {
//            out.print("<p>2 - Cookie name = ${name}; Cookie value = ${value}</p>"
//                        .replace("${name}", cookie.getName())
//                        .replace("${value}", cookie.getValue()));
//        });

        out.print("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h3>Hello World with New Servlet POST!</h3>");

        Arrays.stream(request.getCookies()).toList().forEach(cookie -> {
            out.print("<p>POST - Cookie name = ${name}; Cookie value = ${value}</p>"
                    .replace("${name}", cookie.getName())
                    .replace("${value}", cookie.getValue()));
        });

        out.print("</body></html>");
        out.close();
    }

    /* Helpers */

    private Map<String, String> getCookies(HttpServletRequest req) {
        String cookies = req.getHeader("Cookie");

        if (cookies == null) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();

        String[] separateCookies = cookies.split(";");
        for (String pair : separateCookies) {
            String[] keyValue = pair.split("=");

            result.put(keyValue[0], keyValue[1]);
        }

        return result;
    }
}
