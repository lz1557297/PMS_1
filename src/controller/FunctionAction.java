package controller;

import net.sf.json.JSONArray;
import po.Function;
import po.Mod;
import service.FunctionService;
import service.ModService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FunctionAction {

    private FunctionService service = new FunctionService();
    private ModService ms = new ModService();



    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Function> list = service.queryAll();

//        System.out.println("---------");
//        for (Function p : list) {
//            System.out.println(p);
//        }



        //List<Client> list_c = null;

//        for (Project p : list) {
//            Client client = new Client();
//
//        }
        request.setAttribute("list", list);
        return "showAllFunction.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        String mod_id = request.getParameter("mod");
//        String project_id = request.getParameter("project_id");
        String priority = request.getParameter("priority");
        String function_title = request.getParameter("function_title");
        String function_info = request.getParameter("function_info");
        String mod_title = ms.queryOnemod(Integer.parseInt(mod_id)).getMod_title();

        //System.out.println("------------");


        //String function_title,String function_info,int mod_id,String mod_name,String priority,String function_set_time,String function_update_time

        System.out.println(mod_id+"-"+mod_title+"-"+function_title+"-"+function_info+"-"+priority+"-"+dateNowStr);
        service.insertNewFunction(function_title,function_info,Integer.parseInt(mod_id),mod_title,priority,dateNowStr,dateNowStr);
        return this.queryAll(request, response);  //拿到queryAll的返回值
    }

    //删除单条数据
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String function_id = request.getParameter("function_id");
        service.deleteFunction(Integer.parseInt(function_id));
        return this.queryAll(request, response);
    }

    //查询单条数据
    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String function_id = request.getParameter("function_id");
        Function function= service.queryOneFunction(Integer.parseInt(function_id));
        request.setAttribute("function_id",function_id);

        System.out.println("功能标题");
        System.out.println(function);
        request.setAttribute("function",function);
        System.out.println(function);

        return "showOneFunction.jsp";
    }


    //修改单条数据
    public String update(HttpServletRequest request,HttpServletResponse response){
        String function_id = request.getParameter("function_id");
        String function_title = request.getParameter("function_title");
        String function_info = request.getParameter("function_info");
        String priority = request.getParameter("priority");

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        System.out.println(function_id+"   "+function_title+"  "+function_info+"   "+dateNowStr+"   "+priority);
        service.updateFunction(Integer.parseInt(function_id),dateNowStr,function_title,function_info,priority);
        return this.queryAll(request, response);
    }

    //queryFunctionByMod

    public void queryFunctionByMod(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String mod_id = request.getParameter("value");
        System.out.printf("mod_id: "+mod_id);
        List<Function> mods = service.queryFunctionByMod(Integer.parseInt(mod_id));


        System.out.println("queryFunctionByMod result");
        for (Function n :
                mods) {
            System.out.println(n);
        }

        PrintWriter out = response.getWriter();
        out.write(JSONArray.fromObject(mods).toString());
        out.flush();


    }
}
