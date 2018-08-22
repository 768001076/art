package net.sjl.thread;

import com.caucho.hessian.client.HessianProxyFactory;
import net.sjl.hession.HessionProviderTestService;

import java.net.MalformedURLException;

public class HessianExceptionTest extends Thread {

    @Override
    public void run() {
        System.out.println("开始");
        String url = "http://127.0.0.1:6543/hessionProviderTestService";
        HessianProxyFactory factory = new HessianProxyFactory();
        HessionProviderTestService service = null;
        try {
            service = (HessionProviderTestService)factory.create(HessionProviderTestService.class,
                    url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(service);
        System.out.println(service.hello());
        System.out.println(service.getHessionBean().toString());
        System.out.println("结束");
    }
}
