package stage;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "Servlet_img", value = "/ImageCodeServlet")
public class Servlet_img extends HttpServlet {


    private static final String CODE_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int width = 80;
        int height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        Random random = new Random();
        g.setColor(new Color(220, 220, 220));
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("宋体", Font.BOLD, 20));

        // 随机生成字符串验证码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(CODE_LIST.length());
            char c = CODE_LIST.charAt(index);
            sb.append(c);
            g.setColor(new Color(random.nextInt(128), random.nextInt(128), random.nextInt(128)));
            g.drawString(String.valueOf(c), (i + 1) * 15, 25);
        }

        // 将生成的验证码存入session中以便验证
        HttpSession session = request.getSession();
        session.setAttribute("imageCode", sb.toString());

        // 图片输出到页面
        response.setContentType("image/jpeg");

        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "jpeg", os);

    }


















    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}
