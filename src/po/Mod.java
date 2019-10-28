package po;

public class Mod {
    private Project project;
    private int mod_id;
    private String mod_title;
    private String mod_info;
    private int need_id;
    private String need_name;
    private String priority;
    private String mod_set_time;
    private String mod_update_time;


    public Mod(Project project, int mod_id, String mod_title, String mod_info, int need_id, String need_name, String priority, String mod_set_time, String mod_update_time) {
        this.project = project;
        this.mod_id = mod_id;
        this.mod_title = mod_title;
        this.mod_info = mod_info;
        this.need_id = need_id;
        this.need_name = need_name;
        this.priority = priority;
        this.mod_set_time = mod_set_time;
        this.mod_update_time = mod_update_time;
    }

    public Mod() {
    }

    public int getMod_id() {
        return mod_id;
    }

    public void setMod_id(int mod_id) {
        this.mod_id = mod_id;
    }

    public String getMod_title() {
        return mod_title;
    }

    public void setMod_title(String mod_title) {
        this.mod_title = mod_title;
    }

    public String getMod_info() {
        return mod_info;
    }

    public void setMod_info(String mod_info) {
        this.mod_info = mod_info;
    }

    public int getNeed_id() {
        return need_id;
    }

    public void setNeed_id(int need_id) {
        this.need_id = need_id;
    }

    public String getNeed_name() {
        return need_name;
    }

    public void setNeed_name(String need_name) {
        this.need_name = need_name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getMod_set_time() {
        return mod_set_time;
    }

    public void setMod_set_time(String mod_set_time) {
        this.mod_set_time = mod_set_time;
    }

    public String getMod_update_time() {
        return mod_update_time;
    }

    public void setMod_update_time(String mod_update_time) {
        this.mod_update_time = mod_update_time;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Mod{" +
                "project=" + project +
                ", mod_id=" + mod_id +
                ", mod_title='" + mod_title + '\'' +
                ", mod_info='" + mod_info + '\'' +
                ", need_id=" + need_id +
                ", need_name='" + need_name + '\'' +
                ", priority='" + priority + '\'' +
                ", mod_set_time='" + mod_set_time + '\'' +
                ", mod_update_time='" + mod_update_time + '\'' +
                '}';
    }
}
