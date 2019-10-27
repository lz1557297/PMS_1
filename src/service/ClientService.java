package service;

import dao.ClientDao;
import po.Client;
import po.Role;

import java.util.List;

public class ClientService {
    private ClientDao dao = new ClientDao();

    public List<Client> queryAll(){
        return dao.queryAllClient();
    }

    public void insertNewClient(String client_name,String client_pre,String client_tel,String client_addr,String client_back,String client_set_time){
        Client client = new Client();
        client.setClient_name(client_name);
        client.setClient_pre(client_pre);
        client.setClient_tel(client_tel);
        client.setClient_addr(client_addr);
        client.setClient_back(client_back);
        client.setClient_set_time(client_set_time);
        dao.insert(client);
    }

    public Client queryOneClient(int client_id){
        return dao.load(client_id);
    }
    public void updateClient(int client_id,String client_tel,String client_addr){
        //获取到更新之前的旧数据
        Client client = dao.load(client_id);
        client.setClient_tel(client_tel);
        client.setClient_addr(client_addr);
        dao.update(client);
    }

    public void deleteClient(int client_id){
        dao.delete(client_id);
    }
}
