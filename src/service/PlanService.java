package service;

import dao.PlanDao;
import po.Plan;

import java.util.List;

public class PlanService {
    private PlanDao dao = new PlanDao();
    private NeedService ns = new NeedService();
    private ProjectService ps = new ProjectService();

    public List<Plan> queryAllChecked(){

        return dao.queryAllCheckedPlan();
    }

    public List<Plan> queryAllSubmit(){

        return dao.queryAllSubmit();
    }

    public List<Plan> queryAllDeployedPlanForCoder(int user_id){

        return dao.queryAllDeployedPlanForCoder(user_id);
    }

    public List<Plan> queryAllDeployedPlanForChef(int user_id){

        return dao.queryAllDeployedPlanForChef(user_id);
    }

    public void insertNewPlan(String plan_title,String plan_info,int function_id,String function_title,int chef_id,int deadline,String priority){
        Plan plan = new Plan();
        plan.setPlan_title(plan_title);
        plan.setPlan_info(plan_info);
        plan.setFunction_id(function_id);
        plan.setFunction_title(function_title);
        plan.setChef_id(chef_id);
        plan.setDeadline(deadline);
        plan.setPriority(priority);
        dao.insert(plan);
    }

    public Plan queryOnePlan(int plan_id){

        return dao.load(plan_id);
    }



    public void updatePlan(int plan_id,int deadline,String plan_title,String plan_info,String priority){
        //获取到更新之前的旧数据
        Plan plan = dao.load(plan_id);
//        need.setProject_id(project_id);
//        need.setProject_name(project_name);
        plan.setDeadline(deadline);
        plan.setPlan_title(plan_title);
        plan.setPlan_info(plan_info);
        plan.setPriority(priority);
        dao.update(plan);
    }

    public void updateForCheck(int plan_id){
        Plan plan = dao.load(plan_id);
        dao.updateForCheck(plan);
    }

    public void updateForFlag(int plan_id){
        Plan plan = dao.load(plan_id);
        dao.updateForFlag(plan);
    }

    public void deletePlan(int plan_id){
        dao.delete(plan_id);
    }

    public void deploy(int plan_id,int user_id){
        dao.deploy(plan_id,user_id);
    }




}
