package controller;

import net.sf.json.JSONArray;
import po.Mod;
import po.Need;
import service.ModService;
import service.NeedService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ModAction {

    private ModService service = new ModService();
    private NeedService ns = new NeedService();

    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Mod> list = service.queryAll();
        for (Mod p : list) {
            System.out.println(p);
        }



        //List<Client> list_c = null;

//        for (Project p : list) {
//            Client client = new Client();
//
//        }
        request.setAttribute("list", list);
        return "showAllMod.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        String need_id = request.getParameter("need");
        String project_id = request.getParameter("project_id");
        String priority = request.getParameter("priority");
        String mod_title = request.getParameter("mod_title");
        String mod_info = request.getParameter("mod_info");
        String need_name = ns.queryOneNeed(Integer.parseInt(need_id)).getNeed_title();

        //System.out.println("------------");


        //String mod_title,String mod_info,int need_id,String need_name,String priority,String modd_set_time,String mod_update_time

        System.out.println(project_id+"-"+need_id+"-"+priority+"-"+dateNowStr+"-"+mod_title+"-"+mod_info+"-"+need_name);
        service.insertNewMod(mod_title,mod_info,Integer.parseInt(need_id),need_name,priority,dateNowStr,dateNowStr);
        return this.queryAll(request, response);  //拿到queryAll的返回值
    }

    //删除单条数据
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String mod_id = request.getParameter("mod_id");
        service.deleteMod(Integer.parseInt(mod_id));
        return this.queryAll(request, response);
    }

    //查询单条数据
    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String mod_id = request.getParameter("mod_id");
        Mod mod= service.queryOnemod(Integer.parseInt(mod_id));
        request.setAttribute("mod_id",mod_id);
        request.setAttribute("modd",mod);
        System.out.println(mod);

        return "showOneMod.jsp";
    }


    //修改单条数据
    public String update(HttpServletRequest request,HttpServletResponse response){
        String mod_id = request.getParameter("mod_id");
        String mod_title = request.getParameter("mod_title");
        String mod_info = request.getParameter("mod_info");
        String priority = request.getParameter("priority");

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        System.out.println(mod_id+"   "+mod_title+"  "+mod_info+"   "+dateNowStr+"   "+priority);
        service.updatemod(Integer.parseInt(mod_id),dateNowStr,mod_title,mod_info,priority);
        return this.queryAll(request, response);
    }

    public void queryModByNeed(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String need_id = request.getParameter("value");
        System.out.printf("need_id: "+need_id);
        List<Mod> mods = service.queryModByNeed(Integer.parseInt(need_id));

        for (Mod n :
                mods) {
            System.out.println(n);
        }

        PrintWriter out = response.getWriter();
        out.write(JSONArray.fromObject(mods).toString());
        out.flush();


    }
}
