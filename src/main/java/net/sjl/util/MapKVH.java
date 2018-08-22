package net.sjl.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Map键值互换
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/2/24
 */
public class MapKVH {



    public static void main(String[] args) {
        Map<String,String> fieldMap = new HashMap<String, String>();//属性对应对应关系
        fieldMap.put("id","ID");
        fieldMap.put("orderid","C_ORDERID");
        fieldMap.put("name","C_NAME");
        fieldMap.put("idtype","C_IDTYPE");
        fieldMap.put("idnumber","C_IDNUMBER");
        fieldMap.put("birthday","C_BIRTHDAY");
        fieldMap.put("aduitstatus","C_ADUITSTATUS");
        fieldMap.put("passengerid","C_PASSENGERID");

        for (Map.Entry<String, String> stringStringEntry : fieldMap.entrySet()) {
            System.out.println(stringStringEntry.getValue() + "=" + stringStringEntry.getKey());
        }



    }

}
