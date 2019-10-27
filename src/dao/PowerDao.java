package dao;

import po.Power;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PowerDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();



    //查询某个角色下全部的一级权限
    public List<Power> queryPowerOne(int role_id){
        String sql = "select * from pms_role_power prp,pms_power pp where prp.power_id = pp.power_id and prp.role_id=? and pp.upper_id = 0";
        return JDBCTemplate.queryForList(sql, new Object[]{role_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Power power = new Power();
                power.setPower_id(rs.getInt("power_id"));
                power.setPower_name(rs.getString("power_name"));
                //power.setPhref(rs.getString("phref"));
                power.setUpper_id(rs.getInt("upper_id"));
                return power;
            }
        });
    }


    public List<Power> queryPowerByRoid(int role_id,int upper_id){     //得到一个一级权限下的二级权限列表
        String sql = "select * from pms_role_power rp,pms_power fp where rp.power_id = fp.power_id and rp.role_id=? and fp.upper_id = ?";    //承接上条，fuid为上面查到的一级权限的pid
        return JDBCTemplate.queryForList(sql, new Object[]{role_id, upper_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Power power_sub = new Power();
                power_sub.setPower_id(rs.getInt("power_id"));
                power_sub.setPower_href(rs.getString("power_href"));
                power_sub.setPower_name(rs.getString("power_name"));
                power_sub.setUpper_id(rs.getInt("upper_id"));
                return power_sub;
            }
        });
    }



    @SuppressWarnings("unchecked")
    public List<Power> queryAll(){
        String sql = "select * from pms_power cp";
        return this.jdbcTemplate.queryForList(sql,new rowMapper(){
            public Object mapRow(ResultSet rs) throws SQLException {
                Power po = new Power();
                po.setPower_id(rs.getInt("power_id"));
                po.setPower_name(rs.getString("power_name"));
                po.setUpper_id(rs.getInt("upper_id"));//0
                return po;
            }
        });
    }


    //查询某个角色所具备的全部权限
    @SuppressWarnings("unchecked")
    public List<Power> queryPowerByRole(int role_id){
        String sql = "select * from pms_role_power rp,pms_power cp where rp.power_id = cp.power_id and rp.role_id=?";
        return this.jdbcTemplate.queryForList(sql, new Object[]{role_id},new rowMapper(){
            public Object mapRow(ResultSet rs) throws SQLException {
                Power po = new Power();
                po.setPower_id(rs.getInt("power_id"));
                po.setPower_name(rs.getString("power_name"));
                po.setUpper_id(rs.getInt("upper_id"));//0
                return po;
            }
        });
    }


    //删除某个角色所具备的全部的权限
    public void delete(int role_id){
        String sql = "delete from pms_role_power where role_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{role_id});
    }
    //新增角色和权限的绑定关系
    public void insert(int role_id,int power_id){
        String sql = "insert into pms_role_power (role_id,power_id) values (?,?)";
        this.jdbcTemplate.update(sql, new Object[]{role_id,power_id});
    }
}



