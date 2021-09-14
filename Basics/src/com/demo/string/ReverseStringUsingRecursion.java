package com.demo.string;

public class ReverseStringUsingRecursion {
	public static void main(String[] args) {
		String str = "Ankit Tyagi";
		String reverse = reverseString(str);
		System.out.println(reverse);
	
	}

	private static String reverseString(String str) {
		if(str.isEmpty())
		{
			return str;
		}
		return reverseString(str.substring(1))+str.charAt(0);
	}

}
