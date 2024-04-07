package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/Servlet2",loadOnStartup = 2)
//@WebServlet(value = "/Servlet2",loadOnStartup = 1)
public class Servlet2 implements Servlet {
    public Servlet2(){
        System.out.println("**********构造方法Servlet2执行了**********");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("**********初始化方法init2执行了**********");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("**********服务方法service2执行了**********");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("**********销毁方法destroy2执行了**********");
    }
}
