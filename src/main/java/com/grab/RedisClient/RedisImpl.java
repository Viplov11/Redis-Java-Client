package com.grab.RedisClient;

import java.net.Socket;

public class RedisImpl implements Redis {
	private String host;
	private int port;
	private ConnectionPool pool = new ConnectionPoolImpl();

	public RedisImpl() {
		host = "127.0.0.1";
		port = 6379;
		this.pool.iniitialize(host, port);
	}

	public RedisImpl(String host, int port) {
		this.host = host;
		this.port = port;
		this.pool.iniitialize(host, port);
	}

	public boolean set(String key, String value) {
		// TODO Auto-generated method stub
		Socket clientSocket = ConnectionUtil.connect(this.host, this.port, this.pool);
		String returnedString = CommandUtil.sendCommand(ConnectionUtil.getInputStream(clientSocket),
				ConnectionUtil.getOutputStream(clientSocket), "set " + key + " '" + value + "'");
		ConnectionUtil.close(this.pool, clientSocket);
		if (returnedString.contains("OK")) {
			return true;
		}
		return false;
	}

	public String get(String key) {
		// TODO Auto-generated method stub
		Socket clientSocket = ConnectionUtil.connect(this.host, this.port, this.pool);
		String returnedString = CommandUtil.sendCommand(ConnectionUtil.getInputStream(clientSocket),
				ConnectionUtil.getOutputStream(clientSocket), "get " + key);
		ConnectionUtil.close(this.pool, clientSocket);
		return returnedString;
	}

	public void close() {
		this.pool.closeAll();
	}

	public void setMaxConnections(int numberConn) {
		// TODO Auto-generated method stub
		this.pool.setMaxConnections(numberConn);
	}

	public int getMaxConnections() {
		// TODO Auto-generated method stub
		return this.pool.getMaxConnections();
	}
}
