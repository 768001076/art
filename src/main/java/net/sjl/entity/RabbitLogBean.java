package net.sjl.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/23
 */
public class RabbitLogBean {

    private int count = 0;

    private Map<Integer,Context> dataInfo = new HashMap<Integer, Context>();

    public RabbitLogBean(String info,int datatype) {
        this.count = 1;
        Context context = new Context();
        context.setDataType(datatype);
        context.setDateTime(info.substring(0,info.indexOf("]") + 1));
        this.dataInfo.put(1,context);
    }

    public void updateInfo (String info,int datatype){
        this.count++;
        Context context = new Context();
        context.setDataType(datatype);
        context.setDateTime(info.substring(0,info.indexOf("]") + 1));
        this.dataInfo.put(this.dataInfo.size() + 1,context);
    }

    @Override
    public String toString() {
        return "RabbitLogBean{" +
                "count=" + count +
                ", dataInfo=" + dataInfo.toString() +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<Integer, Context> getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Map<Integer, Context> dataInfo) {
        this.dataInfo = dataInfo;
    }

    public static void main(String[] args) {
        String s = "[2018-01-18 06:00:43.722] 5902683:Rabbit:RabbitMQ_messagetext--->116141742--->下单";
        System.out.println(s.substring(s.indexOf(">") + 1,s.indexOf(">") + 10));
    }
}
class Context {

    private int dataType;

    private String dateTime;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Context{" +
                "dataType=" + dataType +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}