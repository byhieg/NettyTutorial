package chapter2;

/**
 * Created by byhieg on 2018/4/8.
 * Mail to byhieg@gmail.com
 */
public class NIOTimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient-001").start();
    }
}
