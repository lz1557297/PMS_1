package service;

import dao.JobDao;
import po.Job;

import java.util.List;

public class JobService {
    private JobDao dao=new JobDao();
    public List<Job> query(){
        return dao.query();
    }
    public void insert(String job_name){
        Job job=new Job();
        job.setJob_name(job_name);
        dao.insert(job);
    }
    public void delete(int job_id){
        dao.delete(job_id);
    }
    public Job queryOne(int job_id){
        return dao.queryOne(job_id);
    }
    public void update(int job_id,String job_name){
        Job job=dao.queryOne(job_id);
        job.setJob_name(job_name);
        dao.update(job);
    }
}
