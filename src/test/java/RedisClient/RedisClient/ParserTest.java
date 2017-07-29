package RedisClient.RedisClient;

import com.grab.RedisClient.ParserUtil;

import junit.framework.TestCase;

public class ParserTest extends TestCase {
	
	public void testClientLib() {
		assertEquals(0, ParserUtil.getLengthToRead("+OK"));
		assertEquals(2, ParserUtil.getLengthToRead("$2"));
		assertEquals(-1, ParserUtil.getLengthToRead("Testing"));
	}
}
