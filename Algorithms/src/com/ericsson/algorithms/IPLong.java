package com.ericsson.algorithms;

public class IPLong {

	public static String LongToIP(long longIP)
	{
		String ip = "";
		for (int i = 0; i < 4; i++)
		{
			int num = (int) (longIP / Math.pow(256, (3 - i)));
			longIP = longIP - (long) (num * Math.pow(256, (3 - i)));
			if (i == 0)
				ip = num + "";
			else
				ip = ip + "." + num;
		}
		return ip;
	}
	
	public static void main(String[] args) {
		System.out.println(LongToIP(1000000000l));
	}
}
