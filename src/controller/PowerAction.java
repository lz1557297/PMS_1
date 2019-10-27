package controller;

import po.Power;
import service.PowerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PowerAction {
    private PowerService service = new PowerService();

    public String queryPower(HttpServletRequest request, HttpServletResponse response){
        String role_id = request.getParameter("role_id");  //得到selectRole.jsp传过来的roid
        System.out.println(role_id);
        List<Power> list = service.queryAllPowerOne(Integer.parseInt(role_id));//所有一级权限
        Map<String,List<Power>> map = service.queryByRoid(Integer.parseInt(role_id));   //得到一级权限和其下二级权限列表 成为键值对 多个键值对组成map
        request.setAttribute("list", list);
        request.setAttribute("map", map);
        //一级权限名  List<该一级权限的二级权限>

        return "showPower.jsp";
    }

    public String queryAllPower(HttpServletRequest request,HttpServletResponse response){
        //查询全部权限
        String role_id = request.getParameter("role_id");
        List<Power> list = service.queryAllPower();
        request.setAttribute("list", list);
        //查询当前角色所具备的权限
        List<Power> list1 = service.queryPowerByRole(Integer.parseInt(role_id));
        request.setAttribute("list1", list1);
        return "showAllPower.jsp";
    }


    //更新权限
    public String updatePower(HttpServletRequest request,HttpServletResponse response){
        String[] pids = request.getParameterValues("pids");
        String role_id = request.getParameter("role_id");
        service.updatePowerRealation(Integer.parseInt(role_id), pids);
        return "role.do?method=queryAll";
    }
}
