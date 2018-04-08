package chapter2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by byhieg on 2018/4/8.
 * Mail to byhieg@gmail.com
 */
public class ThreadTimeServer {
    public static void main(String[] args) throws IOException {
        int port  = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("the time is start in port: " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = serverSocket.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        }finally {
            if (serverSocket != null) {
                System.out.println("The time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
