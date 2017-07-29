package com.grab.RedisClient;

import java.net.Socket;

public interface ConnectionPool {
	public Socket getSocket();
	public void putSocket(Socket socket);
	public void closeAll();
	public void iniitialize(String host, int port);
	public void setMaxConnections(int connection);
	public int getMaxConnections();
}
