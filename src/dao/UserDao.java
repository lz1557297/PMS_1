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
                user.setRole_id(rs.getInt("role_id"));
                user.setUser_tel(rs.getString("user_tel"));
                user.setUser_email(rs.getString("user_email"));
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
                user.setRole_id(rs.getInt("role_id"));
                user.setUser_tel(rs.getString("user_tel"));
                user.setUser_email(rs.getString("user_email"));
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




    public List<User> loadAllCoder(){
        String sql = "select * from pms_user where job_id = 3";
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

    public void update(User user){
        String sql="update pms_user set username=?,password=?,job_id=?,role_id=?,user_tel=?,user_email=? where user_id=?";
        this.jdbcTemplate.update(sql, new Object[]{user.getUsername(),user.getPassword(),user.getJob_id(),user.getRole_id(),user.getUser_tel(),user.getUser_email(),user.getUser_id()});
    }


    public void delete(int user_id){
        String sql="delete from pms_user where user_id=?";
        this.jdbcTemplate.update(sql, new Object[]{user_id});
    }

    public void updateLimit(User user){
        String sql = "update pms_user set password = ?, user_tel = ?, user_email = ? where user_id = ?";
        JDBCTemplate.update(sql, new Object[]{user.getPassword(),user.getUser_tel(),user.getUser_email(),user.getUser_id()});
//        密码 电话 邮箱
    }


}
