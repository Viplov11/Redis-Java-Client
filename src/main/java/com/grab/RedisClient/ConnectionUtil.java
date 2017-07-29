package com.grab.RedisClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionUtil {

	public static Socket connect(String host, int port, ConnectionPool connectionPool) {
		// TODO Auto-generated method stub
		Socket clientSocket;
		try {
			if (connectionPool != null) {
				clientSocket = connectionPool.getSocket();
				if (clientSocket == null || !clientSocket.isConnected()) {
					clientSocket = new Socket(host, port);
					clientSocket.setKeepAlive(true);
					connectionPool.putSocket(clientSocket);
				}
				return clientSocket;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void close(ConnectionPool connectionPool, Socket clientSocket) {
		if (clientSocket.isConnected()) {
			connectionPool.putSocket(clientSocket);
		}
	}

	public static OutputStream getOutputStream(Socket clientSocket) {
		// TODO Auto-generated method stub
		OutputStream outputStream = null;
		try {
			if (clientSocket.isConnected()) {
				outputStream = clientSocket.getOutputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputStream;
	}

	public static InputStream getInputStream(Socket clientSocket) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		try {
			if (clientSocket.isConnected()) {
				inputStream = clientSocket.getInputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
}
