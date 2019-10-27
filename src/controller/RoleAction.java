package controller;

import po.Role;
import service.RoleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class RoleAction {
    private RoleService service = new RoleService();

    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Role> list = service.queryAll();
        for (Role r : list) {
            System.out.println(r);
        }
        request.setAttribute("list", list);
        return "showAllRole.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        String role_name = request.getParameter("role_name");
        System.out.println("---->"+role_name);
        service.insertNewRole(role_name);
        return this.queryAll(request, response);  //拿到queryAll的返回值
    }


    //删除单条数据
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String role_id = request.getParameter("role_id");
        service.deleteRole(Integer.parseInt(role_id));
        return this.queryAll(request, response);
    }


    //查询单条数据
    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String role_id = request.getParameter("role_id");
        Role role = service.queryOneRole(Integer.parseInt(role_id));
        request.setAttribute("role", role);
        return "showOneRole.jsp";
    }


    //修改单条数据
    public String update(HttpServletRequest request,HttpServletResponse response){
        String role_name = request.getParameter("role_name");
        String role_id = request.getParameter("role_id");
        service.updateRole(Integer.parseInt(role_id), role_name);
        return this.queryAll(request, response);
    }
}
