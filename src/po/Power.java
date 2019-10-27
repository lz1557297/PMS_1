package po;

public class Power {
    private int power_id;
    private String power_href;
    private String power_name;
    private int upper_id;

    public Power(int power_id, String power_href, String power_name, int upper_id) {
        this.power_id = power_id;
        this.power_href = power_href;
        this.power_name = power_name;
        this.upper_id = upper_id;
    }

    public Power() {
    }

    public int getPower_id() {
        return power_id;
    }

    public void setPower_id(int power_id) {
        this.power_id = power_id;
    }

    public String getPower_href() {
        return power_href;
    }

    public void setPower_href(String power_href) {
        this.power_href = power_href;
    }

    public String getPower_name() {
        return power_name;
    }

    public void setPower_name(String power_name) {
        this.power_name = power_name;
    }

    public int getUpper_id() {
        return upper_id;
    }

    public void setUpper_id(int upper_id) {
        this.upper_id = upper_id;
    }

    @Override
    public String toString() {
        return "Power{" +
                "power_id=" + power_id +
                ", power_href='" + power_href + '\'' +
                ", power_name='" + power_name + '\'' +
                ", upper_id=" + upper_id +
                '}';
    }
}
