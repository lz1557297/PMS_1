package service;

import dao.PowerDao;
import po.Power;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerService {
    private PowerDao Dao = new PowerDao();

    public Map<String,List<Power>> queryByRoid(int role_id){
        Map<String,List<Power>> map = new HashMap<String,List<Power>>();
        List<Power> listOne = Dao.queryPowerOne(role_id);//pid 11 12 13 fuid = 0
        for (Power po : listOne){
            //查询某个角色 某一级权限的 全部的二级权限
            List<Power> list = Dao.queryPowerByRoid(role_id,po.getPower_id());   //得到该一级权限下的二级权限列表
            map.put(po.getPower_name(), list);   //成为键值对放入map
        }
        return map;
    }

    public List<Power> queryAllPowerOne(int role_id){
        return Dao.queryPowerOne(role_id);
    }


    public List<Power> queryAllPower(){
        return Dao.queryAll();
    }

    public List<Power> queryPowerByRole(int role_id){
        return Dao.queryPowerByRole(role_id);
    }

    public void updatePowerRealation(int role_id,String[] pids){
        //删除之前全部角色和权限的绑定关系
        Dao.delete(role_id);
        //新增一组新的角色和权限的绑定关系
        for (String pid : pids){
            Dao.insert(role_id, Integer.parseInt(pid));
        }
    }
}
