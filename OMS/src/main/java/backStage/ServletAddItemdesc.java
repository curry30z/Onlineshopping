package backStage;

import Dao.itemDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAddItemdesc", value = "/ServletAddItemdesc")
public class ServletAddItemdesc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //数据处理
        itemDao dao=new itemDao();
        PrintWriter out = response.getWriter();
        String name= request.getParameter("name");
        String itemdesc=request.getParameter("itemdesc");
        int rs=dao.addItem(name,itemdesc);
        if(rs>0){
            out.print("   <script>alert('添加成功！');</script> ");

        }else {
            out.print("   <script>alert('添加失败！');</script> ");


        }

        response.sendRedirect("backStage/Manage.jsp");






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
