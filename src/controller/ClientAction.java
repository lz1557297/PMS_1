package controller;

import po.Client;
import po.Role;
import po.User;
import service.ClientService;
import service.RoleService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ClientAction {

    private ClientService service = new ClientService();
    private UserService us = new UserService();

    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Client> list = service.queryAll();
        for (Client c : list) {
            System.out.println(c);
        }
        request.setAttribute("list", list);
        return "showAllClient.jsp";//xxx.do?method
    }


    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String client_name = request.getParameter("client_name");
        String client_pre = request.getParameter("client_pre");
        String client_tel = request.getParameter("client_tel");
        String client_addr = request.getParameter("client_addr");
        String client_back = request.getParameter("client_back");
        String client_set_time = request.getParameter("client_set_time");

        System.out.println(client_addr);

        service.insertNewClient(client_name,client_pre,client_tel,client_addr,client_back,client_set_time);
        return this.queryAll(request, response);  //拿到queryAll的返回值
    }

    //查询单条数据
    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String client_id = request.getParameter("client_id");
        Client client = service.queryOneClient(Integer.parseInt(client_id));
        request.setAttribute("client", client);
        return "showOneClient.jsp";
    }

    //修改单条数据
    public String update(HttpServletRequest request,HttpServletResponse response){
        String client_tel = request.getParameter("client_tel");
        String client_addr = request.getParameter("client_addr");
        String client_id = request.getParameter("client_id");
        service.updateClient(Integer.parseInt(client_id), client_tel,client_addr);
        return this.queryAll(request, response);
    }

    //删除单条数据
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String client_id = request.getParameter("client_id");
        service.deleteClient(Integer.parseInt(client_id));
        return this.queryAll(request, response);
    }

    public String loadAllClient(HttpServletRequest request, HttpServletResponse response){
        List<Client> list = service.queryAll();
        List<User> listx = us.queryAllChef();

        for (Client client:list) {
            System.out.println(client);
        }

        for (User user:listx) {
            System.out.println(user);
        }

        request.setAttribute("list",list);
        request.setAttribute("listx",listx);
        return "insertProject.jsp";
    }
}
