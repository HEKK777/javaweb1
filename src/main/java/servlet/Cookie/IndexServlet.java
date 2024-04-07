package servlet.Cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cookie.Index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String username = "";
        String checked = "";
        String password = "";
        //得到客户端保存的Cookie数据
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies!=null && i < cookies.length; i++)
        {
            if("username".equals(cookies[i].getName()))
            {
                username = cookies[i].getValue();
                checked = "checked='checked'";
            }
            if("password".equals(cookies[i].getName()))
            {
                password = cookies[i].getValue();
            }
        }
//        免登录
//        if("admin".equals(username) && "1234".equals(password))
//        {
//            resp.sendRedirect("admin.html");
//        }
        out.write("<form action ='"+req.getContextPath()+"/Cookie.Login' method='post'>");
        out.write("用户名：<input type='text' name='username' value='"+username+"'/><br/>");
        out.write("密码：<input type='password' name='password' value='"+password+"'/><br/>");
        out.write("<input type='checkbox' name='remember' "+checked+" />记住用户名和密码<br/>");
        out.write("<input type='submit' value='登录'/><br/>");
        out.write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
