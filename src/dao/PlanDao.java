package dao;

import po.Plan;
import service.FunctionService;
import service.ModService;
import service.NeedService;
import service.ProjectService;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlanDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    private ModService ms = new ModService();
    private NeedService ns = new NeedService();
    private ProjectService ps = new ProjectService();
    private FunctionService fs = new FunctionService();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(plan_id)+1 from pms_plan";
        int index = 0;

        List<Plan> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("max(plan_id)+1"));
                return plan;
            }
        });

        for (Plan p :
                list) {
            index= p.getPlan_id();
        }
        return index;
    }

    public void insert(Plan plan){
        int index = this.queryLength();
        if (index==0){
            index=1;
        }
        String sql = "insert into pms_plan(plan_id,plan_title,plan_info,function_id,function_title,chef_id,deadline,priority) values (?,?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{index,plan.getPlan_title(),plan.getPlan_info(),plan.getFunction_id(),plan.getFunction_title(),plan.getChef_id(),plan.getDeadline(),plan.getPriority()});
    }

    //修改
    public void update(Plan plan){
        String sql = "update pms_plan set deadline = ? ,plan_title = ? ,plan_info = ? ,priority = ? where plan_id = ?";
        JDBCTemplate.update(sql, new Object[]{plan.getDeadline(),plan.getPlan_title(),plan.getPlan_info(),plan.getPriority(),plan.getPlan_id()});
    }

    public void updateForCheck(Plan plan){
        String sql = "update pms_plan set cd = 1 where plan_id = ?";
        JDBCTemplate.update(sql, new Object[]{plan.getPlan_id()});
    }

    public void updateForFlag(Plan plan){
        String sql = "update pms_plan set flag = 1 where plan_id = ?";
        JDBCTemplate.update(sql, new Object[]{plan.getPlan_id()});
    }


    public List<Plan> queryAllCheckedPlan(){
        String sql = "select * from pms_plan where cd = 1 and flag = 0";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("plan_id"));
                plan.setPlan_title(rs.getString("plan_title"));
                plan.setPlan_info(rs.getString("plan_info"));
                plan.setFunction_id(rs.getInt("function_id"));
                plan.setFunction_title(rs.getString("function_title"));
                plan.setChef_id(rs.getInt("chef_id"));
                plan.setDeadline(rs.getInt("deadline"));
                plan.setPriority(rs.getString("priority"));
                plan.setFlag(rs.getInt("flag"));
//                plan.setModd(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getMod_title());
//                plan.setMod(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()));
//                plan.setNeed(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()));
                plan.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()).getProject_id()));
                return plan;
            }
        });
    }

    public List<Plan> queryAllSubmit(){
        String sql = "select * from pms_plan where cd = 0";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("plan_id"));
                plan.setPlan_title(rs.getString("plan_title"));
                plan.setPlan_info(rs.getString("plan_info"));
                plan.setFunction_id(rs.getInt("function_id"));
                plan.setFunction_title(rs.getString("function_title"));
                plan.setChef_id(rs.getInt("chef_id"));
                plan.setDeadline(rs.getInt("deadline"));
                plan.setPriority(rs.getString("priority"));
                plan.setFlag(rs.getInt("flag"));
//                plan.setModd(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getMod_title());
//                plan.setMod(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()));
//                plan.setNeed(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()));
                plan.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()).getProject_id()));
                return plan;
            }
        });
    }


    public List<Plan> queryAllDeployedPlanForCoder(int user_id){
        String sql = "select * from pms_plan pp,pms_coder_plan pcp where pp.plan_id = pcp.plan_id and pp.flag = 1 and pcp.user_id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{user_id},new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("plan_id"));
                plan.setPlan_title(rs.getString("plan_title"));
                plan.setPlan_info(rs.getString("plan_info"));
                plan.setFunction_id(rs.getInt("function_id"));
                plan.setFunction_title(rs.getString("function_title"));
                plan.setChef_id(rs.getInt("chef_id"));
                plan.setDeadline(rs.getInt("deadline"));
                plan.setPriority(rs.getString("priority"));
                plan.setFlag(rs.getInt("flag"));
//                plan.setModd(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getMod_title());
//                plan.setMod(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()));
//                plan.setNeed(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()));
                plan.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()).getProject_id()));
                return plan;
            }
        });
    }

    public List<Plan> queryAllDeployedPlanForChef(int user_id){
        String sql = "select * from pms_plan where flag = 1 and chef_id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{user_id},new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("plan_id"));
                plan.setPlan_title(rs.getString("plan_title"));
                plan.setPlan_info(rs.getString("plan_info"));
                plan.setFunction_id(rs.getInt("function_id"));
                plan.setFunction_title(rs.getString("function_title"));
                plan.setChef_id(rs.getInt("chef_id"));
                plan.setDeadline(rs.getInt("deadline"));
                plan.setPriority(rs.getString("priority"));
                plan.setFlag(rs.getInt("flag"));
//                plan.setModd(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getMod_title());
//                plan.setMod(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()));
//                plan.setNeed(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()));
                plan.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()).getProject_id()));
                return plan;
            }
        });
    }


    //获取单条记录的方法
    public Plan load(int plan_id){
        String sql = "select * from pms_plan where plan_id = ?";
        return (Plan) JDBCTemplate.queryForOnce(sql, new Object[]{plan_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("plan_id"));
                plan.setPlan_title(rs.getString("plan_title"));
                plan.setPlan_info(rs.getString("plan_info"));
                plan.setFunction_id(rs.getInt("function_id"));
                plan.setFunction_title(rs.getString("function_title"));
                plan.setChef_id(rs.getInt("chef_id"));
                plan.setDeadline(rs.getInt("deadline"));
                plan.setPriority(rs.getString("priority"));
                plan.setFlag(rs.getInt("flag"));
//                plan.setMod(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()));
//                plan.setNeed(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()));
                plan.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()).getProject_id()));
                return plan;
            }
        });
    }



    //删除
    public void delete(int plan_id){
        String sql = "delete from pms_plan where plan_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{plan_id});
    }

    public List<Plan> queryPlanByFunction(int function_id){
        String sql = "select * from pms_plan where function_id = ?";
        return jdbcTemplate.queryForList(sql,new Object[]{function_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Plan plan = new Plan();
                plan.setPlan_id(rs.getInt("plan_id"));
                plan.setPlan_title(rs.getString("plan_title"));
                plan.setPlan_info(rs.getString("plan_info"));
                plan.setFunction_id(rs.getInt("function_id"));
                plan.setFunction_title(rs.getString("function_title"));
                plan.setChef_id(rs.getInt("chef_id"));
                plan.setDeadline(rs.getInt("deadline"));
                plan.setPriority(rs.getString("priority"));
                plan.setFlag(rs.getInt("flag"));
                plan.setMod(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()));
                plan.setNeed(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()));
                plan.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(fs.queryOneFunction(plan.getFunction_id()).getMod_id()).getNeed_id()).getProject_id()));
                return plan;
            }
        });
    }

    public void deploy(int plan_id,int user_id){
        String sql = "insert into pms_coder_plan values (?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{user_id,plan_id});

    }
}
