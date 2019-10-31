package dao;

import po.Client;
import po.Project;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProjectDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(project_id)+1 from pms_project";
        int index = 0;

        List<Project> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Project project = new Project();
                project.setProject_id(rs.getInt("max(project_id)+1"));
                return project;
            }
        });

        for (Project p :
                list) {
            index= p.getProject_id();
        }
        return index;
    }

    public void insert(Project project){
        int index = this.queryLength();
        if (index==0){
            index=1;
        }
        String sql = "insert into pms_project values (?,?,?,?,?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{index,project.getProject_name(),project.getClient_id(),project.getClient_name(),project.getUser_id(),project.getUsername(),project.getCoder_count(),project.getProject_set_time(),project.getProject_update_time(),project.getProject_priority(),project.getStatus()});
    }

    //修改
    public void update(Project project){
        String sql = "update pms_project set project_update_time = ? ,project_priority = ? ,coder_count = ? ,status = ? ,user_id = ? ,username = ? where project_id = ?";
        JDBCTemplate.update(sql, new Object[]{project.getProject_update_time(),project.getProject_priority(),project.getCoder_count(),project.getStatus(),project.getUser_id(),project.getUsername(),project.getProject_id()});
    }


    public List<Project> queryAllProject(){
        String sql = "select * from pms_project";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Project project = new Project();
                project.setProject_id(rs.getInt("project_id"));
                project.setProject_name(rs.getString("project_name"));
                project.setClient_id(rs.getInt("client_id"));
                project.setClient_name(rs.getString("client_name"));
                project.setUser_id(rs.getInt("user_id"));
                project.setUsername(rs.getString("username"));
                project.setCoder_count(rs.getInt("coder_count"));
                project.setProject_set_time(rs.getString("project_set_time"));
                project.setProject_update_time(rs.getString("project_update_time"));
                project.setProject_priority(rs.getString("project_priority"));
                project.setStatus(rs.getString("status"));
                return project;
            }
        });
    }


    //获取单条记录的方法
    public Project load(int project_id){
        String sql = "select * from pms_project where project_id = ?";
        return (Project) JDBCTemplate.queryForOnce(sql, new Object[]{project_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Project project = new Project();
                project.setProject_id(rs.getInt("project_id"));
                project.setProject_name(rs.getString("project_name"));
                project.setClient_id(rs.getInt("client_id"));
                project.setClient_name(rs.getString("client_name"));
                project.setUser_id(rs.getInt("user_id"));
                project.setUsername(rs.getString("username"));
                project.setCoder_count(rs.getInt("coder_count"));
                project.setProject_set_time(rs.getString("project_set_time"));
                project.setProject_update_time(rs.getString("project_update_time"));
                project.setProject_priority(rs.getString("project_priority"));
                project.setStatus(rs.getString("status"));
                return project;
            }
        });
    }

    //删除
    public void delete(int project_id){
        String sql = "delete from pms_project where project_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{project_id});
    }
}
