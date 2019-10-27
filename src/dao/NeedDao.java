package dao;

import po.Need;
import po.Project;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NeedDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(need_id)+1 from pms_need";
        int index = 0;

        List<Need> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Need need = new Need();
                need.setNeed_id(rs.getInt("max(need_id)+1"));
                return need;
            }
        });

        for (Need p :
                list) {
            index= p.getNeed_id();
        }
        return index;
    }

    public void insert(Need need){
        int index = this.queryLength();
        String sql = "insert into pms_need values (?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{index,need.getNeed_title(),need.getNeed_info(),need.getProject_id(),need.getProject_name(),need.getNeed_set_time(),need.getNeed_update_time()});
    }

    //修改
    public void update(Need need){
        String sql = "update pms_need set need_update_time = ? ,need_title = ? ,need_info = ? where need_id = ?";
        JDBCTemplate.update(sql, new Object[]{need.getNeed_update_time(),need.getNeed_title(),need.getNeed_info(),need.getNeed_id()});
    }


    public List<Need> queryAllNeed(){
        String sql = "select * from pms_need";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Need need = new Need();
                need.setNeed_id(rs.getInt("need_id"));
                need.setNeed_title(rs.getString("need_title"));
                need.setNeed_info(rs.getString("need_info"));
                need.setProject_id(rs.getInt("project_id"));
                need.setProject_name(rs.getString("project_name"));
                need.setNeed_set_time(rs.getString("need_set_time"));
                need.setNeed_update_time(rs.getString("need_update_time"));
                return need;
            }
        });
    }


    //获取单条记录的方法
    public Need load(int need_id){
        String sql = "select * from pms_need where need_id = ?";
        return (Need) JDBCTemplate.queryForOnce(sql, new Object[]{need_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Need need = new Need();
                need.setNeed_id(rs.getInt("need_id"));
                need.setNeed_title(rs.getString("need_title"));
                need.setNeed_info(rs.getString("need_info"));
                need.setProject_id(rs.getInt("project_id"));
                need.setProject_name(rs.getString("project_name"));
                need.setNeed_set_time(rs.getString("need_set_time"));
                need.setNeed_update_time(rs.getString("need_update_time"));
                return need;
            }
        });
    }

    //删除
    public void delete(int need_id){
        String sql = "delete from pms_need where need_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{need_id});
    }
}
