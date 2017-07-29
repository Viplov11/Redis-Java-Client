package com.grab.RedisClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class CommandUtil{

	public static String sendCommand(InputStream inputStream, OutputStream outputStream, String command) {
		// TODO Auto-generated method stub
		StringBuilder responseString = new StringBuilder();
		PrintWriter writer = null;
		BufferedReader bufferedReader = null;
		writer = new PrintWriter(outputStream, true);
		writer.println(command);
		writer.flush();

		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String str;
		try {
			str = bufferedReader.readLine();
			if(str==null || str.length()==0)
			{
				return null;
			}
			int length=ParserUtil.getLengthToRead(str);
			int i = 0;
			while (i < length) {
				responseString.append(Character.toString((char) bufferedReader.read()));
				i++;
			}
			if(length==0)
			{
				responseString.append(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return responseString.toString();
	}
}
