package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/Servlet1",loadOnStartup = 1)
//@WebServlet(value = "/Servlet1",loadOnStartup = 2)
public class Servlet1 implements Servlet {
    public Servlet1(){
        System.out.println("**********构造方法Servlet1执行了**********");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("**********初始化方法init1执行了**********");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("**********服务方法service1执行了**********");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("**********销毁方法destroy1执行了**********");
    }
}
