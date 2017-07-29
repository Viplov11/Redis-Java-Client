package RedisClient.RedisClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.grab.RedisClient.ConnectionPool;
import com.grab.RedisClient.ConnectionUtil;

import junit.framework.TestCase;

public class ConnectionTest extends TestCase {
	public void testConnection() {
		ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        
        ConnectionPool pool=new ConnectionPool() {
			
			public void putSocket(Socket socket) {
				// TODO Auto-generated method stub
				
			}
			
			public void iniitialize(String host, int port) {
				// TODO Auto-generated method stub
				
			}
			
			public Socket getSocket() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void closeAll() {
				// TODO Auto-generated method stub
				
			}

			public void setMaxConnections(int connection) {
				// TODO Auto-generated method stub
				
			}

			public int getMaxConnections() {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		Socket clientSocket = ConnectionUtil.connect("127.0.0.1", 4444, pool);
		ConnectionUtil.close(pool, clientSocket);
		assertTrue(!clientSocket.isClosed());
		
		assertNotNull(ConnectionUtil.getInputStream(clientSocket));
		assertNotNull(ConnectionUtil.getOutputStream(clientSocket));
		
		Socket clientSocket1 = ConnectionUtil.connect("127.0.0.1", 4444, null);
		assertNull(clientSocket1);
		
        try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
