package dao;

import po.Mod;
import po.Need;
import po.Project;
import service.NeedService;
import service.ProjectService;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ModDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    private NeedService ns = new NeedService();
    private ProjectService ps = new ProjectService();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(mod_id)+1 from pms_mod";
        int index = 0;

        List<Mod> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Mod mod = new Mod();
                mod.setMod_id(rs.getInt("max(mod_id)+1"));
                return mod;
            }
        });

        for (Mod p :
                list) {
            index= p.getMod_id();
        }
        return index;
    }

    public void insert(Mod mod){
        int index = this.queryLength();
        if (index==0){
            index=1;
        }
        String sql = "insert into pms_mod values (?,?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{index,mod.getMod_title(),mod.getMod_info(),mod.getNeed_id(),mod.getNeed_name(),mod.getPriority(),mod.getMod_set_time(),mod.getMod_update_time()});
    }

    //修改
    public void update(Mod mod){
        String sql = "update pms_mod set mod_update_time = ? ,mod_title = ? ,mod_info = ? ,priority = ? where mod_id = ?";
        JDBCTemplate.update(sql, new Object[]{mod.getMod_update_time(),mod.getMod_title(),mod.getMod_info(),mod.getPriority(),mod.getMod_id()});
    }


    public List<Mod> queryAllMod(){
        String sql = "select * from pms_mod";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Mod mod = new Mod();
                //mod.setProject((Project) rs.getObject("project"));
                mod.setMod_id(rs.getInt("mod_id"));
                mod.setMod_title(rs.getString("mod_title"));
                mod.setMod_info(rs.getString("mod_info"));
                mod.setNeed_id(rs.getInt("need_id"));
                mod.setNeed_name(rs.getString("need_name"));
                mod.setPriority(rs.getString("priority"));
                mod.setMod_set_time(rs.getString("mod_set_time"));
                mod.setMod_update_time(rs.getString("mod_update_time"));
                mod.setProject(ps.queryOneProject(ns.queryOneNeed(mod.getNeed_id()).getProject_id()));
                return mod;
            }
        });
    }


    //获取单条记录的方法
    public Mod load(int mod_id){
        String sql = "select * from pms_mod where mod_id = ?";
        return (Mod) JDBCTemplate.queryForOnce(sql, new Object[]{mod_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Mod mod = new Mod();
                //mod.setProject((Project) rs.getObject("project"));
                mod.setMod_id(rs.getInt("mod_id"));
                mod.setMod_title(rs.getString("mod_title"));
                mod.setMod_info(rs.getString("mod_info"));
                mod.setNeed_id(rs.getInt("need_id"));
                mod.setNeed_name(rs.getString("need_name"));
                mod.setPriority(rs.getString("priority"));
                mod.setMod_set_time(rs.getString("mod_set_time"));
                mod.setMod_update_time(rs.getString("mod_update_time"));
                return mod;
            }
        });
    }



    //删除
    public void delete(int mod_id){
        String sql = "delete from pms_mod where mod_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{mod_id});
    }

    public List<Mod> queryModByNeed(int need_id){
        String sql = "select * from pms_mod where need_id = ?";
        return jdbcTemplate.queryForList(sql,new Object[]{need_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Mod mod = new Mod();
                //mod.setProject((Project) rs.getObject("project"));
                mod.setMod_id(rs.getInt("mod_id"));
                mod.setMod_title(rs.getString("mod_title"));
                mod.setMod_info(rs.getString("mod_info"));
                mod.setNeed_id(rs.getInt("need_id"));
                mod.setNeed_name(rs.getString("need_name"));
                mod.setPriority(rs.getString("priority"));
                mod.setMod_set_time(rs.getString("mod_set_time"));
                mod.setMod_update_time(rs.getString("mod_update_time"));
                return mod;
            }
        });
    }
}
