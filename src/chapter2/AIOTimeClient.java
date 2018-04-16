package chapter2;

/**
 * Created by byhieg on 2018/4/16.
 * Mail to byhieg@gmail.com
 */
public class AIOTimeClient {

	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {

			}
		}
		new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIO-AsyncTimeClientHandler-001").start();
	}
}
