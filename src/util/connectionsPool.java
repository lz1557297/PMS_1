package util;

import java.util.ArrayList;
import java.util.List;

public class connectionsPool {
    private static List<myConnection> pools = new ArrayList<>();   //用于存储连接的集合
    static {
        for (int i = 0; i < 5; i++) {
            myConnection mc = new myConnection(i);
            pools.add(mc);
        }
    }

    public synchronized static myConnection findConnection(){
        myConnection mc = null;
        int count = 0;
        while (mc == null){
            for (myConnection conn:pools) {
                if (!conn.isUsed()){  //若连接未被占用
                    conn.setUsed(true);   //占用
                    mc = conn;
                    break;
                }
            }

            if (count>50){  //已等待5秒
                System.out.println("连接超时，稍后重试");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++;
        }

        return mc;
    }


}
