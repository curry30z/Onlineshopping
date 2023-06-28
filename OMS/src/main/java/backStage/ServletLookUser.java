package backStage;

import Dao.userDao;
import bean.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletLookUser", value = "/ServletLookUser")
public class ServletLookUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        PrintWriter out = response.getWriter();
        //数据处理
        int id= Integer.parseInt(request.getParameter("id"));
        userDao dao= new userDao();
        List<user> list =dao.SelectById(id);
        user u= list.get(0);
        HttpSession session= request.getSession();
        session.setAttribute("u",u);
        response.sendRedirect("stage/userIndex.jsp");








    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);

    }
}
