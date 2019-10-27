package service;

import dao.ProjectDao;
import po.Project;

import java.util.List;

public class ProjectService {
    private ProjectDao dao = new ProjectDao();

    public List<Project> queryAll(){
        return dao.queryAllProject();
    }

    public void insertNewProject(String project_name,int client_id,String client_name,int user_id,String username,int coder_count,String project_set_time,String project_update_time,String project_priority,String status){
        Project project = new Project();
        project.setProject_name(project_name);
        project.setClient_id(client_id);
        project.setClient_name(client_name);
        project.setUser_id(user_id);
        project.setUsername(username);
        project.setCoder_count(coder_count);
        project.setProject_set_time(project_set_time);
        project.setProject_update_time(project_update_time);
        project.setProject_priority(project_priority);
        project.setStatus(status);
        dao.insert(project);
    }

    public Project queryOneProject(int project_id){
        return dao.load(project_id);
    }



    public void updateProject(int project_id,int user_id,String username,String status,int coder_count,String project_update_time,String priority){
        //获取到更新之前的旧数据
        Project project = dao.load(project_id);
        project.setProject_update_time(project_update_time);
        project.setCoder_count(coder_count);
        project.setUser_id(user_id);
        project.setUsername(username);
        project.setStatus(status);
        project.setProject_priority(priority);
        dao.update(project);
    }

    public void deleteProject(int project_id){
        dao.delete(project_id);
    }
}
