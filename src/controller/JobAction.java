package controller;

import po.Job;
import service.JobService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class JobAction {

    private JobService service = new JobService();

    public String query(HttpServletRequest request, HttpServletResponse response){
        List<Job> list=service.query();
        request.setAttribute("list", list);
        return "showjob.jsp";
    }
    public String insert(HttpServletRequest request, HttpServletResponse response){
        String job_name=request.getParameter("job_name");
        service.insert(job_name);
        return this.query(request, response);
    }
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String job_id=request.getParameter("job_id");
        service.delete(Integer.parseInt(job_id));
        return this.query(request, response);
    }
    public String queryOne(HttpServletRequest request, HttpServletResponse response){
        String job_id=request.getParameter("job_id");
        Job job=service.queryOne(Integer.parseInt(job_id));
        request.setAttribute("job", job);
        return "showOneJob.jsp";
    }
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String job_name=request.getParameter("job_name");
        String job_id=request.getParameter("job_id");
        service.update(Integer.parseInt(job_id),job_name);
        return this.query(request, response);
    }
}
