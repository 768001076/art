package net.sjl.http.proxy.test;


import com.alibaba.fastjson.JSONObject;
import net.sjl.http.proxy.util.HttpRequest;
import net.sjl.http.proxy.util.HttpResponse;

/**
 * @Description: 获取代理
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/2/10
 */
public class GetProxyMsgUtil {

    private boolean Debug = true;

    private final String apiUrl = "http://dps.kuaidaili.com/api/getdps/?orderid=971816044742376&num=1&ut=1&format=json&sep=1"; //API链接

    public String getProxy(){
        HttpRequest request = new HttpRequest();
        try{
            HttpResponse response = request.sendGet(apiUrl, null);
            int code = response.getCode();
            String content = response.getContent();
            if (Debug) {
                System.out.println(code);
                System.out.println(content);
            }
            if (code == 200) {
                JSONObject contentJson = JSONObject.parseObject(content);
                JSONObject data = contentJson.getJSONObject("data");
                return data.getJSONArray("proxy_list").getString(0);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        String proxy = new GetProxyMsgUtil().getProxy();
        System.out.println("////" + proxy);
    }


}
