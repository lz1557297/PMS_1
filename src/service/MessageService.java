package service;

import dao.ClientDao;
import dao.MessageDao;
import po.Client;
import po.Message;

import java.util.List;

public class MessageService {

    private MessageDao dao = new MessageDao();

    public List<Message> queryAll(){
        return dao.queryAllMessage();
    }

    public void insertNewMessage(String sender,int sender_id,String receiver,int receiver_id,String message_title,String message_info,String send_time){
        Message message = new Message();
        message.setSender(sender);
        message.setSender_id(sender_id);
        message.setReceiver(receiver);
        message.setReceiver_id(receiver_id);
        message.setMessage_title(message_title);
        message.setMessage_info(message_info);
        message.setSend_time(send_time);
        System.out.println(message);
        dao.insert(message);
    }

    public Message queryOneMessage(int message_id){
        return dao.load(message_id);
    }

    public List<Message> queryMySentMessage(int sender_id){
        return dao.queryMySentMessage(sender_id);
    }

    public List<Message> queryMyReceivedMessage(int receiver_id){
        return dao.queryMyReceivedMessage(receiver_id);
    }

    public void deleteMyReceivedMessage(int receiver_id,int message_id){
        dao.deleteMyReceivedMessage(receiver_id,message_id);
    }

    public void deleteMySentMessage(int sender_id,int message_id){
        dao.deleteMySentMessage(sender_id,message_id);
    }

    public List<Message> showMessageByPage(int page) throws Exception{    //按页查询
        int perPage = 5;
        int begin = 0+(page-1)*perPage;
        System.out.println(begin+"-begin");
        int end = perPage;
        System.out.println(end+"-end");
        return dao.queryMessageByPage(begin, end);
    }

}
