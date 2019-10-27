package po;

public class Need {
    private int need_id;
    private String need_title;
    private String need_info;
    private int project_id;
    private  String project_name;
    private String need_set_time;
    private String need_update_time;

    public Need(int need_id, String need_title, String need_info, int project_id, String project_name, String need_set_time, String need_update_time) {
        this.need_id = need_id;
        this.need_title = need_title;
        this.need_info = need_info;
        this.project_id = project_id;
        this.project_name = project_name;
        this.need_set_time = need_set_time;
        this.need_update_time = need_update_time;
    }

    public Need() {
    }

    public int getNeed_id() {
        return need_id;
    }

    public void setNeed_id(int need_id) {
        this.need_id = need_id;
    }

    public String getNeed_title() {
        return need_title;
    }

    public void setNeed_title(String need_title) {
        this.need_title = need_title;
    }

    public String getNeed_info() {
        return need_info;
    }

    public void setNeed_info(String need_info) {
        this.need_info = need_info;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getNeed_set_time() {
        return need_set_time;
    }

    public void setNeed_set_time(String need_set_time) {
        this.need_set_time = need_set_time;
    }

    public String getNeed_update_time() {
        return need_update_time;
    }

    public void setNeed_update_time(String need_update_time) {
        this.need_update_time = need_update_time;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    @Override
    public String toString() {
        return "Need{" +
                "need_id=" + need_id +
                ", need_title='" + need_title + '\'' +
                ", need_info='" + need_info + '\'' +
                ", project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", need_set_time='" + need_set_time + '\'' +
                ", need_update_time='" + need_update_time + '\'' +
                '}';
    }
}
