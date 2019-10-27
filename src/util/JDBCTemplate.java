package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
    public static void update(String sql,Object[] values){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        myConnection mc = connectionsPool.findConnection();
        try {
            conn = mc.getConn();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pst.setObject(i+1,values[i]);
            }
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mc.setUsed(false);
        }
    }

    public static Object queryForOnce(String sql, Object[] values, rowMapper rm){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        myConnection mc = connectionsPool.findConnection();
        Object obj = null;
        try {
            conn = mc.getConn();
            pst = conn.prepareStatement(sql);
            for (int j = 0; j <values.length ; j++) {
                pst.setObject(j+1,values[j]);
            }
            rs = pst.executeQuery();


            if (rs.next()){
                obj = rm.mapRow(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mc.setUsed(false);
        }
        return obj;
    }

    public Object queryForOnce(String sql, rowMapper rm){
        return this.queryForOnce(sql, null, rm);
    }

    public static List queryForList(String sql, Object[] values, rowMapper rm){
        List list = new ArrayList();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        myConnection mc = connectionsPool.findConnection();
        Object obj = null;

                conn = mc.getConn();
        try {
            pst = conn.prepareStatement(sql);
            if (values !=null){
                for (int i = 0; i < values.length; i++) {
                    pst.setObject(i+1,values[i]);
                }
            }
            rs = pst.executeQuery();
            while (rs.next()){
                obj = rm.mapRow(rs);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mc.setUsed(false);
        }
        return list;
    }

    public List queryForList(String sql, rowMapper rm){
        return this.queryForList(sql, null, rm);
    }


}
