package controller;

import po.Client;
import po.Project;
import po.User;
import service.ClientService;
import service.ProjectService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProjectAction {

    private ProjectService service = new ProjectService();
    private ClientService  cs = new ClientService();
    private UserService us = new UserService();
    private ProjectService ps = new ProjectService();

    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Project> list = service.queryAll();
        for (Project p : list) {
            System.out.println(p);
        }

        //List<Client> list_c = null;

//        for (Project p : list) {
//            Client client = new Client();
//
//        }
        request.setAttribute("list", list);
        return "showAllProject.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);


        String project_name = request.getParameter("project_name");
        String client_id = request.getParameter("client_id");
        String client_name = cs.queryOneClient(Integer.parseInt(client_id)).getClient_name();
        String user_id = request.getParameter("user_id");
        String username = us.queryOne(user_id).getUsername();
        String coder_count = request.getParameter("coder_count");
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");


        System.out.println(project_name+"-"+client_id+"-"+client_name+"-"+user_id+"-"+username+"-"+coder_count+"-"+dateNowStr+"-"+priority+"-"+status);

        service.insertNewProject(project_name,Integer.parseInt(client_id),client_name,Integer.parseInt(user_id),username,Integer.parseInt(coder_count),dateNowStr,dateNowStr,priority,status);
        return this.queryAll(request, response);  //拿到queryAll的返回值
    }


    //删除单条数据
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String project_id = request.getParameter("project_id");
        service.deleteProject(Integer.parseInt(project_id));
        return this.queryAll(request, response);
    }



    //查询单条数据
    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String project_id = request.getParameter("project_id");
        Project project = service.queryOneProject(Integer.parseInt(project_id));
        List<User> list = us.queryAllChef();
        request.setAttribute("project_id",project_id);
        request.setAttribute("list",list);
        request.setAttribute("project", project);
        return "showOneProject.jsp";
    }

    //修改单条数据
    public String update(HttpServletRequest request,HttpServletResponse response){
        String project_id = request.getParameter("project_id");
        String user_id = request.getParameter("user_id");
        String username = us.queryOne(user_id).getUsername();
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");
        String coder_count = request.getParameter("coder_count");

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        System.out.println(project_id+"   "+user_id+"  "+username+"   "+priority+"   "+status+"   "+coder_count);
        service.updateProject(Integer.parseInt(project_id),Integer.parseInt(user_id),username,status,Integer.parseInt(coder_count),dateNowStr,priority);
        return this.queryAll(request, response);
    }

    public String loadAllProject(HttpServletRequest request, HttpServletResponse response){
        List<Project> list = ps.queryAll();

        for (Project project:list) {
            System.out.println(project);
        }

//        for (User user:listx) {
//            System.out.println(user);
//        }

        request.setAttribute("list",list);
        //request.setAttribute("listx",listx);
        return "insertNeed.jsp";
    }

    public String loadAllProjectForMod(HttpServletRequest request, HttpServletResponse response){
        List<Project> list = ps.queryAll();

        for (Project project:list) {
            System.out.println(project);
        }

//        for (User user:listx) {
//            System.out.println(user);
//        }

        request.setAttribute("list",list);
        //request.setAttribute("listx",listx);
        return "insertMod.jsp";
    }




    public String loadAllProjectForFunction(HttpServletRequest request, HttpServletResponse response){
        List<Project> list = ps.queryAll();

        for (Project project:list) {
            System.out.println(project);
        }

//        for (User user:listx) {
//            System.out.println(user);
//        }

        request.setAttribute("list",list);
        //request.setAttribute("listx",listx);
        return "insertFunction.jsp";
    }



    public String loadAllProjectForPlan(HttpServletRequest request, HttpServletResponse response){
        List<Project> list = ps.queryAll();

        for (Project project:list) {
            System.out.println(project);
        }

//        for (User user:listx) {
//            System.out.println(user);
//        }
        System.out.println("loadAllProjectForPlan跳转");
        request.setAttribute("list",list);
        //request.setAttribute("listx",listx);
        return "insertPlan.jsp";
    }

}
