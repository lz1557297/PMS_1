package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpSession session = request.getSession();
        String user_id = (String)session.getAttribute("user_id");
        String[] uri = request.getRequestURI().split("/");
        if (user_id != null || uri[uri.length-1].equals("code.do") || uri[uri.length-1].equals("login.do")){
            arg2.doFilter(arg0, arg1);
        }else{
            request.getRequestDispatcher("/index.jsp").forward(arg0, arg1);
        }

    }

    @Override
    public void destroy() {

    }
}
