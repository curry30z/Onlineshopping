package backStage;

import Dao.goodsDao;
import bean.goods;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletUpGoods", value = "/ServletUpGoods")
public class ServletUpGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //处理数据
        String play=request.getParameter("play");
        PrintWriter out=response.getWriter();
        int  id= Integer.parseInt(request.getParameter("id"));
        int rs=-1;
        goodsDao dao=new goodsDao();
        if(play.equals("d")){
                goods g= dao.SelectGoodsById(id).get(0);
            //删除头像文件
            // 指定要删除的文件夹路径
            String folderPath = "F:/OMS/web/backStage/img";

            // 指定要删除的图片名称
            String imageName =g.getPicturename();

            // 创建一个File对象，表示要删除的文件夹
            File folder = new File(folderPath);

            // 获取该文件夹中的所有文件
            File[] files = folder.listFiles();
            for (File file : files) {

                // 判断是否是指定名称的图片文件
                if (file.isFile() && file.getName().equals(imageName)) {

                    // 如果是指定名称的图片，就删除
                    file.delete();

                    // 删除成功，打印一条提示信息
                    System.out.println("指定图片删除成功！");
                    break;
                }
            }





            rs=dao.deleteByGoodSno(id);



        }else if (play.equals("u")){
            rs=dao.setByGoodSno(id);


        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        if(rs>0) {
            out.print("   <script>alert('操作成功！');window.location.href='backStage/Manage.jsp' </script> ");

        }else {
            out.print("   <script>alert('操作失败');window.location.href='backStage/Manage.jsp' </script> ");

        }






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);
    }
}
