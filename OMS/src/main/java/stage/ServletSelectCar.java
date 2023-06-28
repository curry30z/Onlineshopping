package stage;

import Dao.carDao;
import bean.car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletSelectCafr", value = "/ServletSelectCar")
public class ServletSelectCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
       String u=request.getParameter("id");
       int id= Integer.parseInt(u);
       HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        carDao dao = new carDao();
        if(u==null||u.equals("")){
            out.print("   <script>alert('没有登录快去登录！');window.location.href='stage/login.jsp' </script> ");
            return;

        }
        List<car> list= dao.SelectById(id);
        session.setAttribute("carList",list);
        response.sendRedirect("stage/car.jsp");









    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);
    }
}
