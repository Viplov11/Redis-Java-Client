package com.grab.RedisClient;

public interface Redis {
	public boolean set(String key, String value);
	public String get(String key);
	public void close();
	public void setMaxConnections(int numberConn);
	public int getMaxConnections();
}
