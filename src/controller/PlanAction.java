package controller;

import po.Function;
import po.Plan;
import po.User;
import service.FunctionService;
import service.PlanService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PlanAction {
    private PlanService service = new PlanService();
    private FunctionService fs = new FunctionService();
    private UserService us = new UserService();
    //查询全部数据
    public String queryAllChecked(HttpServletRequest request, HttpServletResponse response){
        List<Plan> list = service.queryAllChecked();

//        System.out.println("---------");
//        for (Plan p : list) {
//            System.out.println(p);
//        }



        //List<Client> list_c = null;

//        for (Project p : list) {
//            Client client = new Client();
//
//        }
        request.setAttribute("list", list);
        return "showAllCheckedPlan.jsp";//xxx.do?method
    }

    //查询全部数据
    public String queryAllSubmit(HttpServletRequest request, HttpServletResponse response){
        List<Plan> list = service.queryAllSubmit();

//        System.out.println("---------");
//        for (Plan p : list) {
//            System.out.println(p);
//        }



        //List<Client> list_c = null;

//        for (Project p : list) {
//            Client client = new Client();
//
//        }
        request.setAttribute("list", list);
        return "showAllSubmitPlan.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        String function_id = request.getParameter("function");
        String priority = request.getParameter("priority");
        String plan_title = request.getParameter("plan_title");
        String plan_info = request.getParameter("plan_info");
        String function_title = fs.queryOneFunction(Integer.parseInt(function_id)).getFunction_title();
        String chef_id =(String) request.getSession().getAttribute("user_id");
        String deadline = request.getParameter("deadline");

        //System.out.println("------------");


        //String plan_title,String plan_info,int function_id,String function_title,int chef_id,int deadline,String priority

        System.out.println(function_id+"-"+function_title+"-"+plan_title+"-"+plan_info+"-"+priority);
        service.insertNewPlan(plan_title,plan_info,Integer.parseInt(function_id),function_title,Integer.parseInt(chef_id),Integer.parseInt(deadline),priority);
        return "info.jsp";  //拿到queryAll的返回值
    }

    public String updateForCheck(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        String plan_id = request.getParameter("plan_id");
        service.updateForCheck(Integer.parseInt(plan_id));
        return "info_1.jsp";  //拿到queryAll的返回值
    }

//    queryOne

    public String queryCoder(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        List<User> list = us.queryAllCoder();
        String plan_id = request.getParameter("plan_id");
        request.setAttribute("plan_id",plan_id);
        request.setAttribute("list",list);
        //service.updateForCheck(Integer.parseInt(plan_id));
        return "deploy.jsp";  //拿到queryAll的返回值
    }



    public String write(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        String[] user = request.getParameterValues("ddl");
        String plan_id = request.getParameter("plan_id");
        for (String u :
                user) {
            System.out.println(u);
        }

        System.out.println("--------");
        System.out.println(plan_id);
        //System.out.println(user);
//        request.setAttribute("plan_id",plan_id);
//        request.setAttribute("list",list);

        for (String u:
             user) {
            service.deploy(Integer.parseInt(plan_id),Integer.parseInt(u));
        }
        service.updateForFlag(Integer.parseInt(plan_id));

        return "deploy_info.jsp";  //拿到queryAll的返回值
    }

    public String showPlan(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        String user_id =(String) request.getSession().getAttribute("user_id");
        int identify = us.queryOne(user_id).getJob_id();

        if (identify == 2){
            //List<Plan> list = service.
            List<Plan> list = service.queryAllDeployedPlanForChef(Integer.parseInt(user_id));
            request.setAttribute("list",list);
            return "showPlanForChef.jsp";
        } else
        if (identify == 3){
            List<Plan> list = service.queryAllDeployedPlanForCoder(Integer.parseInt(user_id));
            for (Plan p :
                    list) {
                System.out.println(p);
            }
            request.setAttribute("list",list);
            return "showPlanForCoder.jsp";
        } else {
            return "error.jsp";
        }





        //service.updateForCheck(Integer.parseInt(plan_id));
        //return "deploy.jsp";  //拿到queryAll的返回值
    }



}
