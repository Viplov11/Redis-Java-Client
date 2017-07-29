package com.grab.RedisClient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPoolImpl implements ConnectionPool {

	private int maxConnections = 10;
	private Queue<Socket> connectionPool = new LinkedBlockingQueue<Socket>();

	public Socket getSocket() {
		// TODO Auto-generated method stub
		if (this.connectionPool.size() >= 1) {
			return this.connectionPool.poll();
		}
		return null;
	}

	public void putSocket(Socket socket) {
		// TODO Auto-generated method stub
		if (this.connectionPool.size() >= maxConnections) {
			this.connectionPool.poll();
		}
		this.connectionPool.add(socket);
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		if (maxConnections >= 1) {
			this.maxConnections = maxConnections;
		}
	}

	public void iniitialize(String host, int port){
		for(int i=0;i<maxConnections;i++)
		{
			Socket newSocket;
			try {
				newSocket = new Socket(host,port);
				newSocket.setKeepAlive(true);
				this.connectionPool.add(newSocket);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closeAll() {
		for (int i = 0; i < connectionPool.size(); i++) {
			try {
				this.connectionPool.poll().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
