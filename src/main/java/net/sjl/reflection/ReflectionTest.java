package net.sjl.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 反射测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/2/24
 */
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String,String> filedmap = new HashMap<String, String>();
        filedmap.put("testid","id");
        filedmap.put("name","name");
        filedmap.put("price","price");

        Map<String,Object> datemap = new HashMap<String, Object>();
        datemap.put("testid",1);
        datemap.put("name","name");
        datemap.put("price",18.8f);

        ReflectBean reflectBean = new ReflectBean();
        Class reflectBeanClass = reflectBean.getClass();

        for (String fieldname : datemap.keySet()) {
            Field field = reflectBeanClass.getDeclaredField(filedmap.get(fieldname));
            field.setAccessible(true);
            field.set(reflectBean,datemap.get(fieldname));
        }

        System.out.println(reflectBean.toString());

    }

}
