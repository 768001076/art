package net.sjl.entity;

import java.io.Serializable;

/**
 * @Description: hession测试实体类
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/18
 */
public class HessionBean implements Serializable {
    private static final long serialVersionUID = 8188635334349202328L;

    private String host;

    private String port;

    private String url;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HessionBean{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
