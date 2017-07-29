package RedisClient.RedisClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.grab.RedisClient.ConnectionPool;
import com.grab.RedisClient.ConnectionPoolImpl;

import junit.framework.TestCase;

public class ConnectionPoolTest extends TestCase {
	public void testConnectionPool() {
		ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
        }
        
        ConnectionPool pool=new ConnectionPoolImpl();
        pool.setMaxConnections(5);
        pool.putSocket(new Socket());
        assertTrue(!pool.getSocket().isConnected());
        pool.iniitialize("127.0.0.1", 4444);
        pool.closeAll();
        assertEquals(5, pool.getMaxConnections());
		assertNotNull(pool.getSocket());
		assertTrue(pool.getSocket().isConnected());
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
