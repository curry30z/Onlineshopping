package backStage;

import Dao.userDao;
import bean.user;
import com.sun.org.apache.bcel.internal.generic.Select;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletSelectUser", value = "/ServletSelectUser")
public class ServletSelectUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //处理数据
        userDao dao = new userDao();
        String key=request.getParameter("key");
        List<user> list=dao.SelectByKey(key);
        //传递数据
            HttpSession session=request.getSession();
        session.setAttribute("userList",list);

            response.sendRedirect("backStage/Manage.jsp");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request, response);
    }
}
