package stage;

import Dao.carDao;
import bean.car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletAddCar", value = "/ServletAddCar")
public class ServletAddCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //数据接受
        PrintWriter out = response.getWriter();
        String U= request.getParameter("userid");
        if(U==null||U.equals("")){
            out.print("   <script>alert('没有登录快去登录！');window.location.href='stage/login.jsp' </script> ");
            return;


        }

        int userid= Integer.parseInt(U);
        int goodsid= Integer.parseInt(request.getParameter("goodsid"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        carDao dao= new carDao();
        List<car> list=dao.SelectByUseridAndGoodsId(userid,goodsid);

        int rs=-1;

        if(list.size()>0){
            rs=dao.updateCarById(userid,goodsid,amount);

        }else {
            rs = dao.addCar(userid, goodsid, amount);
        }
        if(rs>0) {
            out.print("   <script>alert('添加购物车成功！');window.location.href='stage/goodesDetail.jsp' </script> ");

        }else {
            out.print("   <script>alert('添加购物车失败');window.location.href='stage/goodesDetail.jsp' </script> ");

        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);

    }
}
