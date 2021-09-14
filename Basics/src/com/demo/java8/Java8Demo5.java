package com.demo.java8;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Demo5 {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		System.out.println(l);
		
		
	List<Integer> al	= l.stream().filter(i->i%2!=0).collect(Collectors.toList());
		System.out.println(al);
		
		//Use of Streams api
	}

}