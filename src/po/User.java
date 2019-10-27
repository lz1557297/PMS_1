package po;

public class User {
    private int user_id;
    private String username;
    private String password;
    private int job_id;
    private String user_tel;
    private String user_email;
    private int role_id;

    public User(int user_id, String username, String password, int job_id, String user_tel, String user_email, int role_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.job_id = job_id;
        this.user_tel = user_tel;
        this.user_email = user_email;
        this.role_id = role_id;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", job_id=" + job_id +
                ", user_tel='" + user_tel + '\'' +
                ", user_email='" + user_email + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
