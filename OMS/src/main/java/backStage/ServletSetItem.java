package backStage;

import Dao.itemDao;
import bean.item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletSetItem", value = "/ServletSetItem")
public class ServletSetItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //数据处理

        String name=null;
        String itemdesc=null;
        try {
            name = request.getParameter("name");
            itemdesc = request.getParameter("itemdesc");
        }catch (NullPointerException e){
            System.out.println("1");

        }finally {


            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));
            String play = request.getParameter("play");
            int rs = -1;
            itemDao dao = new itemDao();
            if (play.equals("d")) {
                rs = dao.deleteItemById(id);

            } else if (play.equals("s")) {

                List<item> list = dao.SelectById(id);
                item i = list.get(0);
                HttpSession session = request.getSession();
                session.setAttribute("it", i);
                response.sendRedirect("backStage/setItem.jsp");
                return;

            } else if (play.equals("u")) {
                rs=dao.updateItemById(id,name,itemdesc);



            }

            if (rs > 0) {
                out.print("   <script>alert('操作成功！');window.location.href='backStage/Manage.jsp' </script> ");

            } else {
                out.print("   <script>alert('操作失败');window.location.href='backStage/Manage.jsp' </script> ");

            }


        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request, response);

    }
}
