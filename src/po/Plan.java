package po;

public class Plan {
    private Project project;
    private Need need;
    private Mod mod;
    private int plan_id;
    private String plan_title;
    private String plan_info;
    private int function_id;
    private String function_title;
//    private int coder_id;
    private int chef_id;
    private int deadline;
    private String priority;
    private int flag;
    private String modd;

    public Plan(Project project, Need need, Mod mod, int plan_id, String plan_title, String plan_info, int function_id, String function_title, int chef_id, int deadline, String priority, int flag, String modd) {
        this.project = project;
        this.need = need;
        this.mod = mod;
        this.plan_id = plan_id;
        this.plan_title = plan_title;
        this.plan_info = plan_info;
        this.function_id = function_id;
        this.function_title = function_title;
        this.chef_id = chef_id;
        this.deadline = deadline;
        this.priority = priority;
        this.flag = flag;
        this.modd = modd;
    }

    public Plan() {
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

    public Mod getMod() {
        return mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_title() {
        return plan_title;
    }

    public void setPlan_title(String plan_title) {
        this.plan_title = plan_title;
    }

    public String getPlan_info() {
        return plan_info;
    }

    public void setPlan_info(String plan_info) {
        this.plan_info = plan_info;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }

    public String getFunction_title() {
        return function_title;
    }

    public void setFunction_title(String function_title) {
        this.function_title = function_title;
    }

    public int getChef_id() {
        return chef_id;
    }

    public void setChef_id(int chef_id) {
        this.chef_id = chef_id;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getModd() {
        return modd;
    }

    public void setModd(String modd) {
        this.modd = modd;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "project=" + project +
                ", need=" + need +
                ", mod=" + mod +
                ", plan_id=" + plan_id +
                ", plan_title='" + plan_title + '\'' +
                ", plan_info='" + plan_info + '\'' +
                ", function_id=" + function_id +
                ", function_title='" + function_title + '\'' +
                ", chef_id=" + chef_id +
                ", deadline=" + deadline +
                ", priority='" + priority + '\'' +
                ", flag=" + flag +
                ", modd='" + modd + '\'' +
                '}';
    }
}
