package controller;

import dao.UserDao;
import po.Client;
import po.Role;
import po.User;
import service.RoleService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class UserAction {
    private UserDao dao = new UserDao();
    private String charset = "UTF-8";
    private UserService service = new UserService();

    public String login(HttpServletRequest request, HttpServletResponse response){
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        String checkcode = request.getParameter("checkcode");
        String scode = (String)session.getAttribute("check_code");

        UserService us = new UserService();
        RoleService rs = new RoleService();

        System.out.println(user_id+" "+password);
        String result = us.login(user_id,password);
        System.out.println(result);


        //checkcode.equals(scode)

        if (checkcode.equals(scode)){
            String rex_id = "[a-zA-Z]{1,3}";
            String rex_password = "[0-9a-z]{1,6}";
            String path = "";
            if (!user_id.matches(rex_id)){
                request.setAttribute("result","账号长度不正确");
                path =  "index.jsp";
            }
            if (!password.matches(rex_password)){
                request.setAttribute("result","密码长度不正确");
                path = "index.jsp";
            }
            if (result.equals("active")){
                List<Role> list = rs.queryRoleById(Integer.parseInt(user_id));
                request.getSession().setAttribute("user_id", user_id);
                request.setAttribute("list", list);
                path = "selectRole.jsp";
            }else{
                request.setAttribute("result", result);
                path = "index.jsp";
            }
            return path;
        }else{
            request.setAttribute("result", "验证码错误");
            return "index.jsp";
        }
    }


    public String loadAllUser(HttpServletRequest request, HttpServletResponse response){
        List<User> list = service.queryAll();

        for (User user:list) {
            System.out.println(user);
        }

        request.setAttribute("list",list);
        return "sendMessage.jsp";
    }


    public String insert(HttpServletRequest request, HttpServletResponse response){
        String user_id = request.getParameter("user_id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String job = request.getParameter("job");
        String role = request.getParameter("role");
        String user_tel = request.getParameter("user_tel");
        String user_email = request.getParameter("user_email");

        System.out.println(user_id+"-"+username+"-"+password+"-"+job+"-"+role+"-"+user_tel+"-"+user_email);

        service.insertNewUser(username,Integer.parseInt(user_id),password,Integer.parseInt(job),Integer.parseInt(role),user_tel,user_email);
        System.out.println("insert");
        return "member_main.jsp";
    }

    public void loadUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //request.setCharacterEncoding(charset);
        String user_id = request.getParameter("user_id");

        User user = dao.load(user_id);

        String result = "<font color='green'>可以注册</font>";
        if (user != null){
            result = "<font color='red'>不可以注册</font>";
        }
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
    }

    public String query(HttpServletRequest request,HttpServletResponse response){
        List<User> list=service.query();
        request.setAttribute("list", list);
        return "showuser.jsp";
    }

    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String id=request.getParameter("user_id");
        User user =service.queryOne(id);
        request.setAttribute("user", user);
        return "showOneUser.jsp";
    }

    public String update(HttpServletRequest request,HttpServletResponse response){
        String user_id =request.getParameter("user_id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String job_id=request.getParameter("job_id");
        String role_id=request.getParameter("role_id");
        String user_tel=request.getParameter("user_tel");
        String user_email=request.getParameter("user_email");
        service.update(user_id,username, password, Integer.parseInt(job_id),Integer.parseInt(role_id),user_tel,user_email);
        return this.query(request, response);
    }

    public String delete(HttpServletRequest request,HttpServletResponse response){
        String id=request.getParameter("user_id");
        service.delete(Integer.parseInt(id));
        return this.query(request, response);
    }

    public String loadUserForUser(HttpServletRequest request, HttpServletResponse response){
        String user_id = (String) request.getSession().getAttribute("user_id");
        System.out.println(user_id);
        UserService us = new UserService();
        User user = service.queryOne(user_id);
        request.setAttribute("user", user);
        return "showPersonalInfo.jsp";
    }

    public String loadOne(HttpServletRequest request, HttpServletResponse response){
        String user_id = (String) request.getSession().getAttribute("user_id");
        User user = service.queryOne(user_id);
        request.setAttribute("user", user);
        return "updatePersonalInfo.jsp";
    }

    public String updateLimit(HttpServletRequest request,HttpServletResponse response){
        String user_id = (String) request.getSession().getAttribute("user_id");
        System.out.println("user_id-----------------"+user_id);
        User user = service.queryOne(user_id);
        request.setAttribute("user", user);
        String password = request.getParameter("password");
        String user_tel = request.getParameter("user_tel");
        String user_email = request.getParameter("user_email");
        service.updateUser(Integer.parseInt(user_id), password,user_tel,user_email);
        return this.loadUserForUser(request, response);
    }
}
