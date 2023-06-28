package stage;

import Dao.userDao;
import bean.user;
import common.MD5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao dao=new userDao();

        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置

            PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
            String username=request.getParameter("username");
            String password = request.getParameter("password");
        String imageCode = (String) session.getAttribute("imageCode");

        String inputCode = request.getParameter("code");

        if (!imageCode.equalsIgnoreCase(inputCode)) {
            out.print("   <script>alert('验证码错误！！');window.location.href='stage/login.jsp' </script> ");

            return ;
            // 验证码错误，处理错误逻辑
        }

        List<user> list = dao.login(username,new MD5().getMd5pwd(password));
        if(list.size()>0){

           session.setAttribute("user",list.get(0));
            if(list.get(0).getTypes().equals("0")) {
                response.sendRedirect("backStage/Manage.jsp");
                return;
            }else {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.

                response.sendRedirect("stage/index.jsp");

            }

        }
        else {
            out.print("   <script>alert('账户或者密码错误！！');window.location.href='stage/login.jsp' </script> ");

        }








    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request, response);
    }
}
