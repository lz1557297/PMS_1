package po;

public class Client {
    private String client_name;
    private int client_id;
    private String client_pre;
    private String client_tel;
    private String client_addr;
    private String client_back;
    private String client_set_time;

    public Client(String client_name, int client_id, String client_pre, String client_tel, String client_addr, String client_back, String client_set_time) {
        this.client_name = client_name;
        this.client_id = client_id;
        this.client_pre = client_pre;
        this.client_tel = client_tel;
        this.client_addr = client_addr;
        this.client_back = client_back;
        this.client_set_time = client_set_time;
    }

    public Client() {
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_pre() {
        return client_pre;
    }

    public void setClient_pre(String client_pre) {
        this.client_pre = client_pre;
    }

    public String getClient_tel() {
        return client_tel;
    }

    public void setClient_tel(String client_tel) {
        this.client_tel = client_tel;
    }

    public String getClient_addr() {
        return client_addr;
    }

    public void setClient_addr(String client_addr) {
        this.client_addr = client_addr;
    }

    public String getClient_back() {
        return client_back;
    }

    public void setClient_back(String client_back) {
        this.client_back = client_back;
    }

    public String getClient_set_time() {
        return client_set_time;
    }

    public void setClient_set_time(String client_set_time) {
        this.client_set_time = client_set_time;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_name='" + client_name + '\'' +
                ", client_id=" + client_id +
                ", client_pre='" + client_pre + '\'' +
                ", client_tel='" + client_tel + '\'' +
                ", client_addr='" + client_addr + '\'' +
                ", client_back='" + client_back + '\'' +
                ", client_set_time='" + client_set_time + '\'' +
                '}';
    }
}
