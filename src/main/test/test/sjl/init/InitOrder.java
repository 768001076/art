package test.sjl.init;

/**
 * @Description:初始化加载顺序测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/1/9
 */
public class InitOrder extends InitOrderFather {

    static {
        System.out.println("静态块");
    }

    public InitOrder() {
        System.out.println("构造");
    }

    public static void init(){
        System.out.println("静态方法");
    }

}
class InitOrderFather{
    static {
        System.out.println("父类静态块");
    }

    public InitOrderFather() {
        System.out.println("父类构造");
    }

    public static void init(){
        System.out.println("父类静态方法");
    }
}