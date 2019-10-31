package dao;

import po.Function;
import po.Mod;
import service.ModService;
import service.NeedService;
import service.ProjectService;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FunctionDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    private NeedService ns = new NeedService();
    private ProjectService ps = new ProjectService();
    private ModService ms = new ModService();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(function_id)+1 from pms_function";
        int index = 0;

        List<Function> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Function function = new Function();
                function.setFunction_id(rs.getInt("max(function_id)+1"));
                return function;
            }
        });

        for (Function p :
                list) {
            index= p.getFunction_id();
        }
        return index;
    }

    public void insert(Function function){
        int index = this.queryLength();
        if (index==0){
            index=1;
        }
        String sql = "insert into pms_function values (?,?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{index,function.getFunction_title(),function.getFunction_info(),function.getMod_id(),function.getMod_title(),function.getPriority(),function.getFunction_set_time(),function.getFunction_update_time()});
    }

    //修改
    public void update(Function function){
        String sql = "update pms_function set function_update_time = ? ,function_title = ? ,function_info = ? ,priority = ? where function_id = ?";
        JDBCTemplate.update(sql, new Object[]{function.getFunction_update_time(),function.getFunction_title(),function.getFunction_info(),function.getPriority(),function.getFunction_id()});
    }


    public List<Function> queryAllFunction(){
        String sql = "select * from pms_function";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Function function = new Function();
                //mod.setProject((Project) rs.getObject("project"));
                function.setFunction_id(rs.getInt("function_id"));
                function.setFunction_title(rs.getString("function_title"));
                function.setFunction_info(rs.getString("function_info"));
                function.setMod_id(rs.getInt("mod_id"));
                function.setMod_title(rs.getString("mod_name"));
                function.setPriority(rs.getString("priority"));
                function.setFunction_set_time(rs.getString("function_set_time"));
                function.setFunction_update_time(rs.getString("function_update_time"));
                function.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(function.getMod_id()).getNeed_id()).getProject_id()));
                //function.setNeed(ns.queryOneNeed(ms.queryOnemod(function.getMod_id()).getNeed_id()));
                return function;
            }
        });
    }


    //获取单条记录的方法
    public Function load(int function_id){
        String sql = "select * from pms_function where function_id = ?";
        return (Function) JDBCTemplate.queryForOnce(sql, new Object[]{function_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Function function = new Function();
                //mod.setProject((Project) rs.getObject("project"));
                function.setFunction_id(rs.getInt("function_id"));
                function.setFunction_title(rs.getString("function_title"));
                function.setFunction_info(rs.getString("function_info"));
                function.setMod_id(rs.getInt("mod_id"));
                function.setMod_title(rs.getString("mod_name"));
                function.setPriority(rs.getString("priority"));
                function.setFunction_set_time(rs.getString("function_set_time"));
                function.setFunction_update_time(rs.getString("function_update_time"));
                function.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(function.getMod_id()).getNeed_id()).getProject_id()));
                //function.setNeed(ns.queryOneNeed(ms.queryOnemod(function.getMod_id()).getNeed_id()));
                return function;
            }
        });
    }



    //删除
    public void delete(int function_id){
        String sql = "delete from pms_function where function_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{function_id});
    }

    //queryFunctionByMod

    public List<Function> queryFunctionByMod(int mod_id){
        String sql = "select * from pms_function where mod_id = ?";
        return jdbcTemplate.queryForList(sql,new Object[]{mod_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Function function = new Function();
                //mod.setProject((Project) rs.getObject("project"));
                function.setFunction_id(rs.getInt("function_id"));
                function.setFunction_title(rs.getString("function_title"));
                function.setFunction_info(rs.getString("function_info"));
                function.setMod_id(rs.getInt("mod_id"));
                function.setMod_title(rs.getString("mod_name"));
                function.setPriority(rs.getString("priority"));
                function.setFunction_set_time(rs.getString("function_set_time"));
                function.setFunction_update_time(rs.getString("function_update_time"));
                function.setProject(ps.queryOneProject(ns.queryOneNeed(ms.queryOnemod(function.getMod_id()).getNeed_id()).getProject_id()));
                function.setNeed(ns.queryOneNeed(ms.queryOnemod(function.getMod_id()).getNeed_id()));
                return function;
            }
        });
    }
}
