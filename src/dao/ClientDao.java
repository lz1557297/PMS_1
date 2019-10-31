package dao;

import po.Client;

import po.Role;
import util.JDBCTemplate;
import util.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDao {

    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    //增删改查

    //增
    //新增
    public int queryLength(){
        String sql = "select max(client_id)+1 from pms_client";
        int index = 0;

        List<Client> list = jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Client client = new Client();
                client.setClient_id(rs.getInt("max(client_id)+1"));
                return client;
            }
        });

        for (Client r :
                list) {
            index= r.getClient_id();
        }
        return index;
    }

    public void insert(Client client){
        int index = this.queryLength();
        if (index==0){
            index=1;
        }
        String sql = "insert into pms_client values (?,?,?,?,?,?,?)";//并发 并行
        this.jdbcTemplate.update(sql, new Object[]{client.getClient_name(),index,client.getClient_pre(),client.getClient_tel(),client.getClient_addr(),client.getClient_back(),client.getClient_set_time()});
    }

    //修改
    public void update(Client client){
        String sql = "update pms_client set client_tel = ? ,client_addr = ? where client_id = ?";
        JDBCTemplate.update(sql, new Object[]{client.getClient_tel(),client.getClient_addr(),client.getClient_id()});
    }


    public List<Client> queryAllClient(){
        String sql = "select * from pms_client";
        return jdbcTemplate.queryForList(sql, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Client client = new Client();
                client.setClient_id(rs.getInt("client_id"));
                client.setClient_name(rs.getString("client_name"));
                client.setClient_pre(rs.getString("client_pre"));
                client.setClient_tel(rs.getString("client_tel"));
                client.setClient_addr(rs.getString("client_addr"));
                client.setClient_back(rs.getString("client_back"));
                client.setClient_set_time(rs.getString("client_set_time"));
                return client;
            }
        });
    }


    //获取单条记录的方法
    public Client load(int client_id){
        String sql = "select * from pms_client where client_id = ?";
        return (Client) JDBCTemplate.queryForOnce(sql, new Object[]{client_id}, new rowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Client client = new Client();
                client.setClient_id(rs.getInt("client_id"));
                client.setClient_name(rs.getString("client_name"));
                client.setClient_pre(rs.getString("client_pre"));
                client.setClient_tel(rs.getString("client_tel"));
                client.setClient_addr(rs.getString("client_addr"));
                client.setClient_back(rs.getString("client_back"));
                client.setClient_set_time(rs.getString("client_set_time"));
                return client;
            }
        });
    }

    //删除
    public void delete(int client_id){
        String sql = "delete from pms_client where client_id = ?";
        this.jdbcTemplate.update(sql, new Object[]{client_id});
    }
}
