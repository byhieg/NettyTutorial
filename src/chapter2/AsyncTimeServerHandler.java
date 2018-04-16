package chapter2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by byhieg on 2018/4/16. Mail to byhieg@gmail.com
 */
public class AsyncTimeServerHandler implements Runnable {

	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;

	public AsyncTimeServerHandler(int port) {
		this.port = port;
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			System.out.println(port);
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
		} catch (IOException e) {

		}
	}

	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {

		}
	}

	private void doAccept() {

		asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
	}


}
