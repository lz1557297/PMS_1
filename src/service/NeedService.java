package service;

import dao.NeedDao;
import po.Need;

import java.util.List;

public class NeedService {
    private NeedDao dao = new NeedDao();

    public List<Need> queryAll(){
        return dao.queryAllNeed();
    }

    public void insertNewNeed(String need_title,String need_info,int project_id,String project_name,String need_set_time,String need_update_time){
        Need need = new Need();
        need.setNeed_title(need_title);
        need.setNeed_info(need_info);
        need.setProject_id(project_id);
        need.setProject_name(project_name);
        need.setNeed_set_time(need_set_time);
        need.setNeed_update_time(need_update_time);
        dao.insert(need);
    }

    public Need queryOneNeed(int need_id){
        return dao.load(need_id);
    }



    public void updateNeed(int need_id,String need_update_time,String need_title,String need_info){
        //获取到更新之前的旧数据
        Need need = dao.load(need_id);
//        need.setProject_id(project_id);
//        need.setProject_name(project_name);
        need.setNeed_update_time(need_update_time);
        need.setNeed_title(need_title);
        need.setNeed_info(need_info);
        dao.update(need);
    }

    public void deleteNeed(int need_id){
        dao.delete(need_id);
    }
}
