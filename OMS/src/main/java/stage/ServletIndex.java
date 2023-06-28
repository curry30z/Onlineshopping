package stage;

import Dao.goodsDao;
import bean.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ServletIndex", value = "/ServletIndex")

public class ServletIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //清除缓存
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        PrintWriter out=response.getWriter();
        HttpSession session =request.getSession();
        goodsDao dao=new goodsDao();
        List<goods> list= dao.SelectGoods();
        Iterator<goods> iterator = list.iterator();
        while (iterator.hasNext()) {
            goods g= iterator.next();
            if (!g.getStatus().equals("1")) {
                iterator.remove();
            }
        }
        session.setAttribute("gd",list);
       // response.sendRedirect("stage/index.jsp");














    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
