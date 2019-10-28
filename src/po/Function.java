package po;

public class Function {
    private int function_id;
    private String function_title;
    private String function_info;
    private int mod_id;
    private String mod_title;
    private String priority;
    private String function_set_time;
    private String function_update_time;
    private Project project;
    private Need need;

    public Function(int funcntion_id, String function_title, String function_info, int mod_id, String mod_title, String priority, String function_set_time, String function_update_time, Project project, Need need) {
        this.function_id = funcntion_id;
        this.function_title = function_title;
        this.function_info = function_info;
        this.mod_id = mod_id;
        this.mod_title = mod_title;
        this.priority = priority;
        this.function_set_time = function_set_time;
        this.function_update_time = function_update_time;
        this.project = project;
        this.need = need;
    }

    public Function() {
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int funcntion_id) {
        this.function_id = funcntion_id;
    }

    public String getFunction_title() {
        return function_title;
    }

    public void setFunction_title(String function_title) {
        this.function_title = function_title;
    }

    public String getFunction_info() {
        return function_info;
    }

    public void setFunction_info(String function_info) {
        this.function_info = function_info;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getFunction_set_time() {
        return function_set_time;
    }

    public void setFunction_set_time(String function_set_time) {
        this.function_set_time = function_set_time;
    }

    public String getFunction_update_time() {
        return function_update_time;
    }

    public void setFunction_update_time(String function_update_time) {
        this.function_update_time = function_update_time;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Need getNeed() {
        return need;
    }

    public void setNeed(Need need) {
        this.need = need;
    }


    @Override
    public String toString() {
        return "Function{" +
                "function_id=" + function_id +
                ", function_title='" + function_title + '\'' +
                ", function_info='" + function_info + '\'' +
                ", mod_id=" + mod_id +
                ", mod_title='" + mod_title + '\'' +
                ", priority='" + priority + '\'' +
                ", function_set_time='" + function_set_time + '\'' +
                ", function_update_time='" + function_update_time + '\'' +
                ", project=" + project +
                ", need=" + need +
                '}';
    }
}
