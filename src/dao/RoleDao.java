package dao;

import po.Role;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDao{
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();

    public List<Role> queryRoleById(int user_id){
        String sql = "select * from pms_role pr,pms_user_role pur where pr.role_id = pur.role_id and pur.user_id = ?";
        return JDBCTemplate.queryForList(sql, new Object[]{user_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Role role = new Role();
                role.setRole_id(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
                return role;
            }
        });
    }


    public List<Role> queryAllRole(){
        String sql = "select * from pms_role";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Role role = new Role();
                role.setRole_id(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
                return role;
            }
        });
    }

    //新增
    public int queryLength(){
        String sql = "select max(role_id)+1 from pms_role";
        int index = 0;

        List<Role> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Role role = new Role();
                role.setRole_id(rs.getInt("max(role_id)+1"));
                return role;
            }
        });

        for (Role r :
                list) {
            index= r.getRole_id();
        }
        return index;
    }

    public void insert(Role role){
        int index = this.queryLength();
        if (index==0){
            index=1;
        }
        String sql = "insert into pms_role values (?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{index,role.getRole_name()});
    }

    //删除
    public void delete(int role_id){
        String sql = "delete from pms_role where role_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{role_id});
    }

    //获取单条记录的方法
    public Role load(int role_id){
        String sql = "select * from pms_role where role_id = ?";
        return (Role) JDBCTemplate.queryForOnce(sql, new Object[]{role_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Role role = new Role();
                role.setRole_id(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
                return role;
            }
        });
    }

    //修改
    public void update(Role role){
        String sql = "update pms_role set role_name = ? where role_id = ?";
        JDBCTemplate.update(sql, new Object[]{role.getRole_name(),role.getRole_id()});
    }


}
