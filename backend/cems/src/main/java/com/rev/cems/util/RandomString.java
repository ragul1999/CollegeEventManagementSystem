package com.rev.cems.util;

import java.util.Random;

public class RandomString {

	public static String randomPassword()
	{
			String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() <= 8) { 
	            int index = (int) (rnd.nextFloat() * str.length());
	            salt.append(str.charAt(index));
	        }
	        String	password = salt.toString();
	        return password;
		
	}
	

	
}
