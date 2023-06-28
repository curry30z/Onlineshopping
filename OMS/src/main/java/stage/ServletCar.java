package stage;

import Dao.carDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCar", value = "/ServletCar")
public class ServletCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //判断提交操作
        int userid= Integer.parseInt(request.getParameter("userid"));
        String sb = request.getParameter("sb");
        String[] cids = request.getParameterValues("check");
        carDao dao= new carDao();
        int rs = -1;
        PrintWriter out =response.getWriter();

        if("delete".equals(sb)){
            //批量删除处理
            if (cids != null && cids.length > 0) {
                for (String cid : cids) {
                    rs = dao.deleteCarById(Integer.parseInt(cid));
                    if (rs > 0) break;

                }
                if(rs>0) {
                    out.print("   <script>alert('批量删除成功！'); </script> ");
                    response.sendRedirect("ServletSelectCar?id="+userid);

                }else {
                    out.print("   <script>alert('批量删除失败');window.location.href='stage/car.jsp' </script> ");

                }


            } else {
                out.print("   <script>alert('无重新选择');window.location.href='stage/car.jsp' </script> ");
            }
        } else if ("next".equals(sb)){
            //提交购物车到订单交互处理
            // 处理具体的逻辑
            // ...
            return;
        } else if ("".equals(sb) || sb == null || cids == null || cids.length == 0) {
            //进行单个删除
            int id= Integer.parseInt(request.getParameter("id"));
            rs=dao.deleteCarById(id);
            if (rs > 0) {
                //操作成功
                //可以将操作成功的车辆编号存储下来，供前端显示或其他操作
                response.sendRedirect("ServletSelectCar?id="+userid);
            } else {
                //操作失败
                out.print("  <script> window.location.href='stage/car.jsp' </script> ");

            }

        } else {
            //其他情况，进行错误处理，例如输出"无效请求"
        }









    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
