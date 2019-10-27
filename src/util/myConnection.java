package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {
    private static String url;
    private static String user;
    private static String password;

    static {
        url = "jdbc:mysql://localhost:3306/PMS_DB?useSSL=false&serverTimezone=UTC";
        user = "root";
        password = "88888888";
    }

    private Connection conn = null;   //连接初始为空
    private boolean isUsed = false;   //判断连接是否被占用
    private int flag = 0;  //用于标记连接

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public myConnection(int flag){
        this.flag = flag;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
