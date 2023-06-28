package stage;

import Dao.userDao;
import bean.user;
import common.MD5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ServletAddUser", value = "/ServletAddUser")
@MultipartConfig( location = "F:/OMS/web/stage/img", maxFileSize = 1024*1024*10*100)
public class ServletAddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //乱码处理
        request.setCharacterEncoding("UTF-8");//对请求的数据! 进行中文乱码处理，比如注册页面活动的中文信息
        response.setCharacterEncoding("UTF-8");//对响应的数据进行中文乱码处理，比如out输出的信息与中文
        response.setContentType("text/html;charset=UTF-8");//对浏览器进行编码 也可以人工修改浏览器编码设置
        //数据接受
        String  username=request.getParameter("username");
        String password = new MD5().getMd5pwd(request.getParameter("password"));
        String realname = request.getParameter("realname");
        String phone =request.getParameter("phone");
        String email=request.getParameter("email");
        String address = request.getParameter("address");
        String sex=request.getParameter("sex");
        //图片
        String uploadPath = "F:/OMS/web/stage/img";
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

        //添加对象
        user u=new user( username,  password,  sex,  realname,  phone, email,  address, fileName);
         int rs=new userDao().add(u);
        PrintWriter out = response.getWriter();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        if(rs>0) {
            out.print("   <script>alert('注册成功去登录！');window.location.href='stage/login.jsp' </script> ");

        }else {
            out.print("   <script>alert('注册成功失败');window.location.href='stage/addUser.jsp' </script> ");

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
