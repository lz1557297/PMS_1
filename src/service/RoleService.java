package service;

import dao.RoleDao;
import po.Role;

import java.util.List;

public class RoleService {
    private RoleDao dao = new RoleDao();
    public List<Role> queryRoleById(int user_id){
        return dao.queryRoleById(user_id);
    }

    public List<Role> queryAll(){
        return dao.queryAllRole();
    }

    public void insertNewRole(String role_name){
        Role role = new Role();
        //role.setRoid(5L);System.currentTimeMillis();//1/9^4
        role.setRole_name(role_name);
        dao.insert(role);
    }

    public void deleteRole(int role_id){
        dao.delete(role_id);
    }

    public Role queryOneRole(int role_id){
        return dao.load(role_id);
    }

    public void updateRole(int role_id,String role_name){
        //获取到更新之前的旧数据
        Role role = dao.load(role_id);
        role.setRole_name(role_name);
        dao.update(role);
    }
}
