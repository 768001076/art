package net.sjl.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @Description: 方法测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/2
 */
public class MethodTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","时佳磊");
        System.out.println("one:" + jsonObject.size());
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("happy","play game");
        System.out.println("two:" + jsonObject2.size());
        MethodTest.getInstance().Test(0,jsonObject,jsonObject2);
    }

    private MethodTest(){

    }

    private static MethodTest methodTest = new MethodTest();

    public static MethodTest getInstance(){
        return methodTest;
    }

    public void Test(int i,JSONObject... jsonObjects){
        JSONObject jsonObject = new JSONObject();
        for (int j = 0; j < jsonObjects.length; j++) {
            jsonObject.putAll(jsonObjects[j]);
        }
        System.out.println(jsonObject.size());
        for (String s : jsonObject.keySet()) {
            System.out.println(s + ";" + jsonObject.getString(s));
        }

    }

}
