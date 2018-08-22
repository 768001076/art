package net.sjl.hession;


import net.sjl.thread.HessianExceptionTest;

import java.net.MalformedURLException;

/**
 * @Description: hession连接测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/18
 */
public class HessionClientTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        HessianExceptionTest hessianExceptionTest = new HessianExceptionTest();
        hessianExceptionTest.start();
        Thread.sleep(10000);
        System.out.println(hessianExceptionTest.getState());
    }

}
//TERMINATED