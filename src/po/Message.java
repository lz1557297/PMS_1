package po;

public class Message {
    private String sender;
    private String receiver;
    private int message_id;
    private String message_title;
    private String message_info;
    private String send_time;
    private int is_deleted_by_sender;
    private int is_deleted_by_receiver;
    private int sender_id;
    private int receiver_id;

    public Message(String sender, String receiver, int message_id, String message_title, String message_info, String send_time, int is_deleted_by_sender, int is_deleted_by_receiver, int sender_id, int receiver_id) {
        this.sender = sender;
        this.receiver = receiver;
        this.message_id = message_id;
        this.message_title = message_title;
        this.message_info = message_info;
        this.send_time = send_time;
        this.is_deleted_by_sender = is_deleted_by_sender;
        this.is_deleted_by_receiver = is_deleted_by_receiver;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
    }

    public Message() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title;
    }

    public String getMessage_info() {
        return message_info;
    }

    public void setMessage_info(String message_info) {
        this.message_info = message_info;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public int getIs_deleted_by_sender() {
        return is_deleted_by_sender;
    }

    public void setIs_deleted_by_sender(int is_deleted_by_sender) {
        this.is_deleted_by_sender = is_deleted_by_sender;
    }

    public int getIs_deleted_by_receiver() {
        return is_deleted_by_receiver;
    }

    public void setIs_deleted_by_receiver(int is_deleted_by_receiver) {
        this.is_deleted_by_receiver = is_deleted_by_receiver;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message_id=" + message_id +
                ", message_title='" + message_title + '\'' +
                ", message_info='" + message_info + '\'' +
                ", send_time='" + send_time + '\'' +
                ", is_deleted_by_sender=" + is_deleted_by_sender +
                ", is_deleted_by_receiver=" + is_deleted_by_receiver +
                ", sender_id=" + sender_id +
                ", receiver_id=" + receiver_id +
                '}';
    }
}
