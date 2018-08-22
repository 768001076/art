package test.sjl.file;

import net.sjl.entity.RabbitLogBean;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 重复数量测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/12
 */
public class repeat {


    public static void main(String[] args) throws IOException {
        Map<String,RabbitLogBean> data = new HashMap<String, RabbitLogBean>();
        File log = new File("C:\\Users\\Administrator\\Desktop\\2.log");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log),"GBK"));
        String line = "";
        while ((line=reader.readLine()) != null){
            String key = "";
            int datatype = 0;
//            if (line.contains("消息内容")){
//                key = line.substring((line.indexOf("id:") + 3),(line.indexOf("id:") + 12));
//                datatype = 1;
//            }else if (line.contains("取消订单")){
//                key = line.substring((line.indexOf("id:") + 3),(line.indexOf("id:") + 12));
//                datatype = 2;
//            }
            if (line.contains("消息内容")){
                key = line.substring((line.indexOf(">") + 1),(line.indexOf(">") + 10));
                datatype = 1;
            }else if (line.contains("下单")){
                key = line.substring((line.indexOf(">") + 1),(line.indexOf(">") + 10));
                datatype = 2;
            }
            if (data.containsKey(key)){
                data.get(key).updateInfo(line,datatype);
            }else {
                data.put(key,new RabbitLogBean(line,datatype));
            }
        }

        if (reader != null) {
            reader.close();
        }
        int count = 0;
        Set<String> strings = data.keySet();
        for (String key : strings) {
            RabbitLogBean rabbitLogBean = data.get(key);
            if (rabbitLogBean.getCount()%2!=0){
                System.out.println(key + ":" + rabbitLogBean.toString());
            }
            count += rabbitLogBean.getCount();
        }
        System.out.println("总条数:" + count);

    }

}
