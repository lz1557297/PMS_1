package controller;

import po.Client;
import po.Message;
import po.User;
import service.ClientService;
import service.MessageService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MessageAction {
    private MessageService service = new MessageService();
    private UserService us = new UserService();

    //查询全部数据
    public String queryAll(HttpServletRequest request, HttpServletResponse response){


        List<Message> list = service.queryAll();
        for (Message m : list) {
            System.out.println(m);
        }
        request.setAttribute("list", list);
        return "showAllMessage.jsp";//xxx.do?method
    }

    //新增单条数据
    public String insert(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);


        String receiver_id = request.getParameter("receiver_id");
        String message_title = request.getParameter("message_title");
        String message_info = request.getParameter("message_info");

        String sender_id = (String) request.getSession().getAttribute("user_id");

        String sender = us.queryOne(sender_id).getUsername();
        String receiver = us.queryOne(receiver_id).getUsername();

        System.out.println(receiver+"-"+receiver_id+"-"+message_title+"-"+message_info+"-"+sender_id+"-"+sender+"-"+dateNowStr);

        service.insertNewMessage(sender,Integer.parseInt(sender_id),receiver,Integer.parseInt(receiver_id),message_title,message_info,dateNowStr);
        return "messageSend.jsp";  //拿到queryAll的返回值
    }


    //查询单条数据
    public String checkThisOne(HttpServletRequest request,HttpServletResponse response){
        String message_id = request.getParameter("message_id");
        Message message = service.queryOneMessage(Integer.parseInt(message_id));
        request.setAttribute("message", message);
        return "showOneMessage.jsp";
    }

    //查询我发送的消息
    public String queryMySentMessage(HttpServletRequest request, HttpServletResponse response){
        System.out.println("queryMySentMessage");

        String sender_id = (String) request.getSession().getAttribute("user_id");
        System.out.println(sender_id);

        List<Message> list = service.queryMySentMessage(Integer.parseInt(sender_id));
        for (Message m : list) {
            System.out.println(m);
        }
        request.setAttribute("list", list);
        return "showMySentMessage.jsp";//xxx.do?method
    }

    //查询我收到的消息
    public String queryMyReceivedMessage(HttpServletRequest request, HttpServletResponse response){
        System.out.println("queryMySentMessage");

        String receiver_id = (String) request.getSession().getAttribute("user_id");
        System.out.println(receiver_id);

        List<Message> list = service.queryMyReceivedMessage(Integer.parseInt(receiver_id));
        for (Message m : list) {
            System.out.println(m);
        }
        request.setAttribute("list", list);
        return "showMyReceivedMessage.jsp";//xxx.do?method
    }

    //删除我收到的消息
    public String deleteMyReceivedMessage(HttpServletRequest request, HttpServletResponse response){
        System.out.println("deleteMyReceivedMessage");
        String message_id = request.getParameter("message_id");
        String receiver_id = (String) request.getSession().getAttribute("user_id");
        System.out.println(receiver_id);
        service.deleteMyReceivedMessage(Integer.parseInt(receiver_id),Integer.parseInt(message_id));
        return this.queryMyReceivedMessage(request, response);
    }



    //删除我发送的消息
    public String deleteMySentMessage(HttpServletRequest request, HttpServletResponse response){
        System.out.println("deleteMySentMessage");
        String message_id = request.getParameter("message_id");
        String sender_id = (String) request.getSession().getAttribute("user_id");
        System.out.println(sender_id);
        service.deleteMySentMessage(Integer.parseInt(sender_id),Integer.parseInt(message_id));
        return this.queryMySentMessage(request, response);

    }



    public String queryMessageByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String curPagex = request.getParameter("curPage");
        if (curPagex == null){    //1.首先 页码为null curPagex的值初始化为1
            curPagex = "1";
        }
        System.out.println(curPagex+"-");
        List<Message> list = service.showMessageByPage(Integer.parseInt(curPagex));
        request.setAttribute("curPagexxxxx",Integer.parseInt(curPagex));
        request.setAttribute("list",list);
        return "showAllMessage.jsp";
    }

}
