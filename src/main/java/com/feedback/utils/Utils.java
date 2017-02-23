package com.feedback.utils;

public class Utils {

	
	public static String optainUsername(String username)
	{
		if(username.length()> 2)
		{
			return username.substring(0, username.indexOf('@'));
		}
		return null;
	}
}
