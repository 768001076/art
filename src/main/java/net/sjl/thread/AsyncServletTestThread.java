package net.sjl.thread;

import javax.servlet.AsyncContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:异步Servlet测试线程
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/3
 */
public class AsyncServletTestThread extends Thread {

    private AsyncContext ctx = null;

    public AsyncServletTestThread(AsyncContext ctx) {
        super();
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            sleep(3000);
            /*BufferedReader br = new BufferedReader(new InputStreamReader(ctx.getRequest().getInputStream(), "UTF-8"));
            String line = "";
            StringBuffer buf = new StringBuffer();
            while ((line = br.readLine()) != null){
                buf.append(line);
            }
            String re = buf.toString();
            System.out.println(re);*/
            ctx.dispatch("/index.jsp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
