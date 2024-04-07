package servlet.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cookie.Login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        System.out.println(username);
        Cookie ck = new Cookie("username", username);
        Cookie ck2 = new Cookie("password", password);
        //登录判断
        if ("admin".equals(username) && "1234".equals(password)) {
            if (remember != null) {
                ck.setMaxAge(60);//设置有效保存时间
                ck2.setMaxAge(60);//设置有效保存时间
            } else {
                ck.setMaxAge(0);//删除Cookie
                ck2.setMaxAge(0);//删除Cookie
            }
            resp.addCookie(ck);//将Cookie写到客户端
            //再存一个Cookie用于存储密码
            resp.addCookie(ck2);//将Cookie写到客户端
            resp.sendRedirect("admin.html");
        } else {
            out.write("登录失败");
            //设置3秒跳到重新登录
            resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/Cookie.Index");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
