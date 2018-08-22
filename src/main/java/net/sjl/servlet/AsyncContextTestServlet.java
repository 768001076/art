package net.sjl.servlet;

import net.sjl.thread.AsyncServletTestThread;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:异步servlet测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/3
 */
public class AsyncContextTestServlet extends HttpServlet {

    private static final long serialVersionUID = -7351921936531432196L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码类型及响应格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.print("Start=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "<br/>");
        writer.flush();
        //开启异步Servlet
        AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.setTimeout(30*1000);//设置超时时间
        asyncContext.start(new AsyncServletTestThread(asyncContext));//另起线程执行耗时操作

        writer.print("Return=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "<br/>");
        writer.flush();
        writer.close();
    }
}
