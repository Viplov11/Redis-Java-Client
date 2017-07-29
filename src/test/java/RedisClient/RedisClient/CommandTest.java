package RedisClient.RedisClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.grab.RedisClient.CommandUtil;

import junit.framework.TestCase;

public class CommandTest extends TestCase
{
    public void testInputStream()
    {
    	 byte[] data = "$1\r\na\r\n".getBytes();
         InputStream input = new ByteArrayInputStream(data);
         OutputStream output=new ByteArrayOutputStream();
         String response=CommandUtil.sendCommand(input, output, "Get command");
         assertEquals("a", response);
         data = "".getBytes();
         input = new ByteArrayInputStream(data);
         response=CommandUtil.sendCommand(input, output, "Get command");
         assertNull(response);
         data = "+OK".getBytes();
         input = new ByteArrayInputStream(data);
         response=CommandUtil.sendCommand(input, output, "Get command");
         assertEquals("+OK",response);
    }
}
