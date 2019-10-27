package service;

import dao.UserDao;
import po.User;

import java.util.List;

public class UserService {
    private UserDao dao = new UserDao();

    public String login(String id,String password){
        User user = dao.load(id);
        String result = "fail";
        if (user != null){
            if (password.equals(user.getPassword())){
                result = "active";
            }
        }
        return result;
    }

    public List<User> queryAll(){
        return dao.loadAll();
    }

    public User queryOne(String id){
        return dao.load(id);
    }


    public void insertNewUser(String username,int user_id,String password,int job_id,int role_id,String user_tel,String user_email){
        User user = new User();
        //role.setRoid(5L);System.currentTimeMillis();//1/9^4
        user.setUser_id(user_id);
        user.setUsername(username);
        user.setPassword(password);
        user.setJob_id(job_id);
        user.setRole_id(role_id);
        user.setUser_tel(user_tel);
        user.setUser_email(user_email);
        dao.insert(user);
        dao.insert_sub(user);
    }



    public List<User> queryAllChef(){
        return dao.loadAllChef();
    }

}
