package com.grab.RedisClient;

public class ParserUtil{

	public static int getLengthToRead(String result) {
		// TODO Auto-generated method stub
		if(result.startsWith("+OK"))
		{
			return 0;
		}
		else if(result.contains("$"))
		{
			result = result.replace("$", "");
			int length = Integer.parseInt(result);
			return length;
		}
		return -1;
	}

}
