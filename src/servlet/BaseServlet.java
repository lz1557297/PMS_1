package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String,String> map = new HashMap();
        map.put("login.do", "controller.UserAction");
        map.put("power.do", "controller.PowerAction");
        map.put("role.do", "controller.RoleAction");
        map.put("code.do", "controller.CodeAction");
        map.put("client.do", "controller.ClientAction");
        map.put("message.do", "controller.MessageAction");
        map.put("user.do", "controller.UserAction");
        map.put("project.do", "controller.ProjectAction");
        map.put("need.do", "controller.NeedAction");

        String uri = request.getRequestURI();    //得到  /reflect_demo_war_exploded/aa.do
        System.out.println(uri);
        uri = uri.substring(uri.lastIndexOf("/")+1);   //得到  aa.do
        System.out.println(uri);

        String method = request.getParameter("method");
        System.out.println(method);

        try {
            Class cla = Class.forName(map.get(uri));  //创建运行时类
            System.out.println(this.getClass().getName());

            Method m = cla.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);  //获取需要调用的方法
            String rtv = (String) m.invoke(cla.newInstance(),request,response);


            request.getRequestDispatcher("/"+rtv).forward(request,response);
            //System.out.println(rtv);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
