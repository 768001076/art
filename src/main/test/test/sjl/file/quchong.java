package test.sjl.file;

import net.sjl.entity.RabbitLogBean;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 去重
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/12
 */
public class quchong {


    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<String>();
        File log = new File("C:\\Users\\Administrator\\Desktop\\2.log");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log),"GBK"));
        String line = "";
        while ((line=reader.readLine()) != null){
            if (!set.contains(line)){
                set.add(line);
            }
        }

        if (reader != null) {
            reader.close();
        }

        System.out.println("去重后数量:" + set.size());

        for (String s : set) {
            System.out.println(s);
        }

    }

}
