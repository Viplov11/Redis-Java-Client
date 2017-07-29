package RedisClient.RedisClient;

import com.grab.RedisClient.Redis;
import com.grab.RedisClient.RedisImpl;

import junit.framework.TestCase;

public class RedisTest extends TestCase {
   
	public void testClientLib() {
		Redis redis=new RedisImpl();
		boolean isSet = redis.set("viplov", "hired :P");
		assertTrue(isSet);
		assertEquals("hired :P", redis.get("viplov"));
		redis.setMaxConnections(5);
		assertEquals(5, redis.getMaxConnections());
		redis.close();
	}
  
}
