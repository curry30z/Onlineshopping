package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlettest", value = "/Servlettest")
public class Servlettest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        String play = request.getParameter("play");
        String name = request.getParameter("name");
        String itemId = request.getParameter("itrmdesc");
        PrintWriter out = response.getWriter();
        out.println(play+name+itemId+id);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);
    }
}
