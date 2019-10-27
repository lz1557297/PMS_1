package controller;

import po.Need;
import po.Project;
import service.NeedService;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NeedAction {

    private NeedService service = new NeedService();
    private ProjectService ps = new ProjectService();


    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Need> list = service.queryAll();
        for (Need p : list) {
            System.out.println(p);
        }

        //List<Client> list_c = null;

//        for (Project p : list) {
//            Client client = new Client();
//
//        }
        request.setAttribute("list", list);
        return "showAllNeed.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);


        String need_title = request.getParameter("need_title");
        String need_info = request.getParameter("need_info");
        String project_id = request.getParameter("project_id");
        String project_name = ps.queryOneProject(Integer.parseInt(project_id)).getProject_name();


        System.out.println(need_title+"-"+need_info+"-"+project_id+"-"+project_name+"-"+dateNowStr);

        //  String need_title,String need_info,int project_id,String project_name,String need_set_time,String need_update_time
        service.insertNewNeed(need_title,need_info,Integer.parseInt(project_id),project_name,dateNowStr,dateNowStr);
        return this.queryAll(request, response);  //拿到queryAll的返回值
    }

    //删除单条数据
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String need_id = request.getParameter("need_id");
        service.deleteNeed(Integer.parseInt(need_id));
        return this.queryAll(request, response);
    }


    //查询单条数据
    public String queryOne(HttpServletRequest request,HttpServletResponse response){
        String need_id = request.getParameter("need_id");
        Need need= service.queryOneNeed(Integer.parseInt(need_id));
        request.setAttribute("need_id",need_id);
        request.setAttribute("need",need);
        System.out.println(need);

        return "showOneNeed.jsp";
    }


    //修改单条数据
    public String update(HttpServletRequest request,HttpServletResponse response){
        String need_id = request.getParameter("need_id");
        String need_title = request.getParameter("need_title");
        String need_info = request.getParameter("need_info");

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        System.out.println(need_id+"   "+need_title+"  "+need_info+"   "+dateNowStr);
        service.updateNeed(Integer.parseInt(need_id),dateNowStr,need_title,need_info);
        return this.queryAll(request, response);
    }
}
