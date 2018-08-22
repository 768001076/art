package net.sjl.http.proxy.test;

import com.alibaba.fastjson.JSONObject;
import net.sjl.http.proxy.util.HttpRequest;
import net.sjl.http.proxy.util.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * @Description: http代理测试
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/2/10
 */
public class TestAPI {

    private static String apiUrl = "http://dps.kuaidaili.com/api/getdps/?orderid=971816044742376&num=1&ut=1&format=json&sep=1"; //API链接

    public static void main1(String[] args) {
        HttpRequest request = new HttpRequest();

        try {
            HttpResponse response = request.sendGet(apiUrl, null);
            System.out.println(response.getCode());
            String a = response.getContent();
            System.out.println(response.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String pageUrl = "http://dev.kuaidaili.com/testproxy"; //要访问的目标网页
    private static String proxyIp = "182.240.253.238"; //代理服务器IP
    private static String proxyPort = "20521"; //代理服务器IP
    private static String username = "312477581"; //用户名
    private static String password = "pwc1lloa"; //密码

    public static void main112(String[] args) {

        HttpRequest request1 = new HttpRequest();

        try {
            HttpResponse response1 = request1.sendGet(apiUrl, null);
            System.out.println(response1.getCode());
            String a = response1.getContent();
            System.out.println(response1.getContent());
            JSONObject jsonObject = JSONObject.parseObject(a);
            String[] split = jsonObject.getJSONObject("data").getJSONArray("proxy_list").getString(0).split(":");
            proxyIp=split[0];
            proxyPort=split[1];
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpRequest request = new HttpRequest();
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Accept-Encoding", "gzip"); //使用gzip压缩传输数据让访问更快

        Map<String, String> proxySettings = new HashMap<String, String>();
        proxySettings.put("ip", proxyIp);
        proxySettings.put("port", proxyPort);
        proxySettings.put("username", username);
        proxySettings.put("password", password);

        System.out.println("Proxy:" + proxySettings);

        try {
            HttpResponse response = request.sendGet(pageUrl, params, headers, proxySettings);
            System.out.println(response.getCode());
            System.out.println(response.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpRequest request1 = new HttpRequest();

        try {
            HttpResponse response1 = request1.sendGet(apiUrl, null);
            System.out.println(response1.getCode());
            String a = response1.getContent();
            System.out.println(response1.getContent());
            JSONObject jsonObject = JSONObject.parseObject(a);
            String[] split = jsonObject.getJSONObject("data").getJSONArray("proxy_list").getString(0).split(":");
        System.out.println(split.toString());
            proxyIp=split[0];
            proxyPort=split[1];
        } catch (Exception e) {
        }
        System.out.println("代理:" + proxyIp + ":" + proxyPort);
        try {
            BufferedReader reader = null;
            StringBuffer res = new StringBuffer();
            Authenticator authenticator = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication("312477581",
                            "pwc1lloa".toCharArray()));
                }
            };
            Authenticator.setDefault(authenticator);
            URLConnection con = (new URL(pageUrl)).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress
                    (proxyIp, Integer.parseInt(proxyPort))));
//            URLConnection con = (new URL(pageUrl)).openConnection();
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setReadTimeout(60 * 1000);
            con.setConnectTimeout(60 * 1000);
            con.connect();
            InputStream in = con.getInputStream();
            HttpURLConnection conn = (HttpURLConnection) con;
            int statusCode = conn.getResponseCode();
            //判断是否压缩
            if ("gzip".equalsIgnoreCase(con.getHeaderField("Content-Encoding"))) {
                reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(in), "UTF-8"));
            }
            else {
                reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            }
            String lineTxt = null;
            while ((lineTxt = reader.readLine()) != null) {
                res.append(lineTxt);
            }
            System.out.println("stateCode>>>" + statusCode + "<<<<res>>>" + res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
