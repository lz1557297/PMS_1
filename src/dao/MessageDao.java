package dao;

import po.Client;
import po.Message;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MessageDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(message_id)+1 from pms_message";
        int index = 0;

        List<Message> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Message message = new Message();
                message.setMessage_id(rs.getInt("max(message_id)+1"));
                return message;
            }
        });

        for (Message m :
                list) {
            index= m.getMessage_id();
        }
        return index;
    }

    public void insert(Message message){
        int index = this.queryLength();
        String sql = "insert into pms_message values (?,?,?,?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{message.getSender(),message.getSender_id(),message.getReceiver(),message.getReceiver_id(),index,message.getMessage_title(),message.getMessage_info(),message.getSend_time(),message.getIs_deleted_by_sender(),message.getIs_deleted_by_receiver()});
    }

    public List<Message> queryAllMessage(){
        String sql = "select * from pms_message";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Message message = new Message();
                message.setMessage_id(rs.getInt("message_id"));
                message.setSender(rs.getString("sender"));
                message.setReceiver(rs.getString("receiver"));
                message.setMessage_title(rs.getString("message_title"));
                message.setMessage_info(rs.getString("message_info"));
                message.setSend_time(rs.getString("send_time"));
                message.setIs_deleted_by_sender(rs.getInt("is_deleted_by_sender"));
                message.setIs_deleted_by_receiver(rs.getInt("is_deleted_by_receiver"));
                message.setSender_id(rs.getInt("sender_id"));
                message.setReceiver_id(rs.getInt("receiver_id"));
                return message;
            }
        });
    }


    //获取单条记录的方法
    public Message load(int message_id){
        String sql = "select * from pms_message where message_id = ?";
        return (Message) JDBCTemplate.queryForOnce(sql, new Object[]{message_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Message message = new Message();
                message.setMessage_id(rs.getInt("message_id"));
                message.setSender(rs.getString("sender"));
                message.setReceiver(rs.getString("receiver"));
                message.setMessage_title(rs.getString("message_title"));
                message.setMessage_info(rs.getString("message_info"));
                message.setSend_time(rs.getString("send_time"));
                return message;
            }
        });
    }

    //删除
    public void deleteMyReceivedMessage(int receiver_id,int message_id){
        String sql = "update pms_message set is_deleted_by_receiver = 1 where receiver_id = ? and message_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{receiver_id,message_id});
    }

    public void deleteMySentMessage(int sender_id,int message_id){
        String sql = "update pms_message set is_deleted_by_sender = 1 where sender_id = ? and message_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{sender_id,message_id});
    }


    public List<Message> queryMySentMessage(int sender_id){
        String sql = "select * from pms_message where sender_id = ? and is_deleted_by_sender = 0";
        return jdbcTemplate.queryForList(sql, new Object[]{sender_id},new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Message message = new Message();
                message.setMessage_id(rs.getInt("message_id"));
                message.setSender(rs.getString("sender"));
                message.setReceiver(rs.getString("receiver"));
                message.setMessage_title(rs.getString("message_title"));
                message.setMessage_info(rs.getString("message_info"));
                message.setSend_time(rs.getString("send_time"));
                message.setIs_deleted_by_sender(rs.getInt("is_deleted_by_sender"));
                message.setIs_deleted_by_receiver(rs.getInt("is_deleted_by_receiver"));
                message.setSender_id(rs.getInt("sender_id"));
                message.setReceiver_id(rs.getInt("receiver_id"));
                return message;
            }
        });
    }


    public List<Message> queryMyReceivedMessage(int receiver_id){
        String sql = "select * from pms_message where receiver_id = ? and is_deleted_by_receiver = 0";
        return jdbcTemplate.queryForList(sql, new Object[]{receiver_id},new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Message message = new Message();
                message.setMessage_id(rs.getInt("message_id"));
                message.setSender(rs.getString("sender"));
                message.setReceiver(rs.getString("receiver"));
                message.setMessage_title(rs.getString("message_title"));
                message.setMessage_info(rs.getString("message_info"));
                message.setSend_time(rs.getString("send_time"));
                message.setIs_deleted_by_sender(rs.getInt("is_deleted_by_sender"));
                message.setIs_deleted_by_receiver(rs.getInt("is_deleted_by_receiver"));
                message.setSender_id(rs.getInt("sender_id"));
                message.setReceiver_id(rs.getInt("receiver_id"));
                return message;
            }
        });
    }


    public List<Message> queryMessageByPage(int begin,int end){
        String sql = "select * from pms_message limit ?,?";
        return jdbcTemplate.queryForList(sql, new Object[]{begin,end},new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Message message = new Message();
                message.setMessage_id(rs.getInt("message_id"));
                message.setSender(rs.getString("sender"));
                message.setReceiver(rs.getString("receiver"));
                message.setMessage_title(rs.getString("message_title"));
                message.setMessage_info(rs.getString("message_info"));
                message.setSend_time(rs.getString("send_time"));
                message.setIs_deleted_by_sender(rs.getInt("is_deleted_by_sender"));
                message.setIs_deleted_by_receiver(rs.getInt("is_deleted_by_receiver"));
                message.setSender_id(rs.getInt("sender_id"));
                message.setReceiver_id(rs.getInt("receiver_id"));
                return message;
            }
        });
    }





}
