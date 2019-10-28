package service;

import dao.FunctionDao;
import dao.ModDao;
import po.Function;
import po.Mod;

import java.util.List;

public class FunctionService {
    private FunctionDao dao = new FunctionDao();
    private NeedService ns = new NeedService();
    private ProjectService ps = new ProjectService();

    public List<Function> queryAll(){

        return dao.queryAllFunction();
    }

    public void insertNewFunction(String function_title,String function_info,int mod_id,String mod_title,String priority,String function_set_time,String function_update_time){
        Function function = new Function();
        function.setFunction_title(function_title);
        function.setFunction_info(function_info);
        function.setMod_id(mod_id);
        function.setMod_title(mod_title);
        function.setPriority(priority);
        function.setFunction_set_time(function_set_time);
        function.setFunction_update_time(function_update_time);
        dao.insert(function);
    }

    public Function queryOneFunction(int function_id){

        return dao.load(function_id);
    }



    public void updateFunction(int function_id,String function_update_time,String function_title,String function_info,String priority){
        //获取到更新之前的旧数据
        Function function = dao.load(function_id);
//        need.setProject_id(project_id);
//        need.setProject_name(project_name);
        function.setFunction_update_time(function_update_time);
        function.setFunction_title(function_title);
        function.setFunction_info(function_info);
        function.setPriority(priority);
        dao.update(function);
    }

    public void deleteFunction(int function_id){
        dao.delete(function_id);
    }
}
