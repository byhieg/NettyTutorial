package chapter2;

import java.io.IOException;

/**
 * Created by byhieg on 2018/4/8.
 * Mail to byhieg@gmail.com
 */
public class NIOTimeServer {

    public static void main(String[] args)  throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO_MultiplexerTimeServer-001").start();
    }
}
