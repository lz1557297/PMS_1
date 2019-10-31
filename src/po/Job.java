package po;

public class Job {
    private int job_id;
    private String job_name;

    public Job(int job_id, String job_name) {
        this.job_id = job_id;
        this.job_name = job_name;
    }

    public Job() {
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id=" + job_id +
                ", job_name='" + job_name + '\'' +
                '}';
    }
}
