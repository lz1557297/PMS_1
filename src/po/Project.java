package po;

public class Project {
    private int project_id;
    private String project_name;
    private int client_id;
    private String client_name;
    private int user_id;
    private String username;
    private int coder_count;
    private String project_set_time;
    private String project_update_time;
    private String project_priority;
    private String status;

    public Project(int project_id, String project_name, int client_id, String client_name, int user_id, String user_name, int coder_count, String project_set_time, String project_update_time, String project_priority, String status) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.client_id = client_id;
        this.client_name = client_name;
        this.user_id = user_id;
        this.username = user_name;
        this.coder_count = coder_count;
        this.project_set_time = project_set_time;
        this.project_update_time = project_update_time;
        this.project_priority = project_priority;
        this.status = status;
    }

    public Project() {
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoder_count() {
        return coder_count;
    }

    public void setCoder_count(int coder_count) {
        this.coder_count = coder_count;
    }

    public String getProject_set_time() {
        return project_set_time;
    }

    public void setProject_set_time(String project_set_time) {
        this.project_set_time = project_set_time;
    }

    public String getProject_update_time() {
        return project_update_time;
    }

    public void setProject_update_time(String project_update_time) {
        this.project_update_time = project_update_time;
    }

    public String getProject_priority() {
        return project_priority;
    }

    public void setProject_priority(String project_priority) {
        this.project_priority = project_priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", client_id=" + client_id +
                ", client_name='" + client_name + '\'' +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", coder_count=" + coder_count +
                ", project_set_time='" + project_set_time + '\'' +
                ", project_update_time='" + project_update_time + '\'' +
                ", project_priority='" + project_priority + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
