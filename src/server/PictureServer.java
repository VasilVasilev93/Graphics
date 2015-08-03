package server;

import java.io.IOException;
import java.net.ServerSocket;

public class PictureServer {

	public static void main(String args[]) throws IOException {
		ServerSocket listener = new ServerSocket(9090);
		System.out.print("PictureServer started");

		int clientNumber = 0;

		try {
			while (true) {
				new MultiClient(listener.accept(), clientNumber++).start();
			}
		} finally {
			listener.close();
		}
	}

}
