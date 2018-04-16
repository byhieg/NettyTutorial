package chapter2;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by byhieg on 2018/4/16.
 * Mail to byhieg@gmail.com
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncTimeServerHandler>{




	@Override
	public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
		attachment.asynchronousServerSocketChannel.accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer, buffer, new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
		exc.printStackTrace();
		attachment.latch.countDown();
	}
}
