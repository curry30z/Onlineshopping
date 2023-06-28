package backStage;

import Dao.goodsDao;
import Dao.itemDao;
import bean.goods;

import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ServletAddGoods", value = "/ServletAddGoods")
@MultipartConfig( location = "F:/OMS/web/backStage/img", maxFileSize = 1024*1024*10*100)
public class ServletAddGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
//数据接受
        PrintWriter out = response.getWriter();
        itemDao it=new itemDao();
        String  goodsno=request.getParameter("goodsno");
        String  gname=request.getParameter("gname");
        double  price= Double.parseDouble(request.getParameter("price"));
        int  amount= Integer.parseInt(request.getParameter("amount"));
        String  seller=request.getParameter("seller");
        String  iname=request.getParameter("name");//类别名
        int name ;
        try {
            name= (it.SelectByName(iname)).get(0).getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch(IndexOutOfBoundsException e){
            out.print("   <script>alert('输入商品类别有误！');window.location.href='backStage/Manage.jsp' </script> ");
            return;

        }
        String adddate = String.valueOf(new Date());
        double discount = Double.parseDouble(request.getParameter("discount"));
        String describe = request.getParameter("describe");
//图片存入
        String uploadPath = "F:/OMS/web/backStage/img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String fileName = null;
        try {
            // 获取上传的文件列表
            List<Part> fileParts = (List<Part>) request.getParts().stream()
                    .filter(part -> "file".equals(part.getName())).collect(Collectors.toList());

            for (Part filePart : fileParts) {
                fileName = getFileName(filePart);
                File file = new File(uploadDir, fileName);


                // 写入文件
                try (InputStream is = filePart.getInputStream();
                     FileOutputStream fos = new FileOutputStream(file)) {
                    int len;
                    byte[] buffer = new byte[1024];
                    while ((len = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                }
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "上传文件失败: " + e.getMessage());
        }
        //创建对象

        goods g=new goods(goodsno,gname,price,amount,fileName,seller,name,adddate,discount,describe);

        int rs=new goodsDao().insertByGoods(g);

        if(rs>0) {
            out.print("   <script>alert('添加商品成功！');window.location.href='backStage/Manage.jsp' </script> ");

        }else {
            out.print("   <script>alert('添加商品失败');window.location.href='backStage/Manage.jsp' </script> ");

        }












    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 设置临时目录
        ServletContext context = config.getServletContext();
        File tempDir = (File) context.getAttribute(ServletContext.TEMPDIR);
        context.setAttribute("javax.servlet.context.tempdir", tempDir);
    }
}
