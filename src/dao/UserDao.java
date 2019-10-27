package dao;

import po.User;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();

    public User load(String id){
        String sql = "select * from pms_user where user_id = ?";
        //System.out.println(id);
        return (User) JDBCTemplate.queryForOnce(sql, new Object[]{id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setJob_id(rs.getInt("job_id"));
                System.out.println(user);
                return user;
            }
        });
    }

    public List<User> loadAll(){
        String sql = "select * from pms_user";
        //System.out.println(id);
        return (List<User>) jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setJob_id(rs.getInt("job_id"));
                System.out.println(user);
                return user;
            }
        });
    }

    public void insert(User user){
        String sql = "insert into pms_user values (?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{user.getUsername(),user.getUser_id(),user.getPassword(),user.getJob_id(),user.getRole_id(),user.getUser_tel(),user.getUser_email()});
    }

    public void insert_sub(User user){
        String sql = "insert into pms_user_role values (?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{user.getUser_id(),user.getRole_id()});
    }



    public List<User> loadAllChef(){
        String sql = "select * from pms_user where job_id = 2";
        //System.out.println(id);
        return (List<User>) jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setJob_id(rs.getInt("job_id"));
                System.out.println(user);
                return user;
            }
        });
    }

}
