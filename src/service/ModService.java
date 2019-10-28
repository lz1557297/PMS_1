package service;

import dao.ModDao;
import dao.NeedDao;
import po.Mod;
import po.Need;

import java.util.List;

public class ModService {
    private ModDao dao = new ModDao();
    private NeedService ns = new NeedService();
    private ProjectService ps = new ProjectService();

    public List<Mod> queryAll(){

        return dao.queryAllMod();
    }

    public void insertNewMod(String mod_title,String mod_info,int need_id,String need_name,String priority,String modd_set_time,String mod_update_time){
        Mod mod = new Mod();
        mod.setMod_title(mod_title);
        mod.setMod_info(mod_info);
        mod.setNeed_id(need_id);
        mod.setNeed_name(need_name);
        mod.setPriority(priority);
        mod.setMod_set_time(modd_set_time);
        mod.setMod_update_time(mod_update_time);
        dao.insert(mod);
    }

    public Mod queryOnemod(int mod_id){
        Mod mod = dao.load(mod_id);
        mod.setProject(ps.queryOneProject(ns.queryOneNeed(mod.getNeed_id()).getProject_id()));
        return mod;
    }



    public void updatemod(int mod_id,String mod_update_time,String mod_title,String mod_info,String priority){
        //获取到更新之前的旧数据
        Mod mod = dao.load(mod_id);
//        need.setProject_id(project_id);
//        need.setProject_name(project_name);
        mod.setMod_update_time(mod_update_time);
        mod.setMod_title(mod_title);
        mod.setMod_info(mod_info);
        mod.setPriority(priority);
        dao.update(mod);
    }

    public void deleteMod(int mod_id){
        dao.delete(mod_id);
    }
}
