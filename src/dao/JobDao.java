package dao;

import po.Job;

import po.User;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JobDao {

    private JDBCTemplate jdbcTemplate = new JDBCTemplate();

    public List<Job> query(){
        String sql="select * from pms_job";
        return this.jdbcTemplate.queryForList(sql, new rowMapper(){

            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Job job=new Job();
                job.setJob_id(rs.getInt("job_id"));
                job.setJob_name(rs.getString("job_name"));
                return job;
            }});
    }
    public Job queryOne(int job_id){
        String sql="select * from pms_job where job_id=?";
        return  (Job) this.jdbcTemplate.queryForOnce(sql, new Object[]{job_id},new rowMapper(){

            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Job job=new Job();
                job.setJob_id(rs.getInt("job_id"));
                job.setJob_name(rs.getString("job_name"));
                return job;
            }});
    }
    //�޸�
    public void update(Job job) {
        String sql="update pms_job set job_name=? where job_id=?";
        this.jdbcTemplate.update(sql, new Object[]{job.getJob_name(),job.getJob_id()});
    }
    //����
    public void insert(Job job){
        String sql="insert into pms_job values ((select max(job_id)+1 from pms_job),?)";
        this.jdbcTemplate.update(sql, new Object[]{job.getJob_name()});
    }
    public void delete(int job_id){
        String sql="delete from pms_job where job_id=?";
        this.jdbcTemplate.update(sql, new Object[]{job_id});
    }
}
