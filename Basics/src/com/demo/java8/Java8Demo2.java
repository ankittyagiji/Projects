package com.demo.java8;
import java.util.function.Predicate;

public class Java8Demo2 {
	public static void main(String[] args) {
		Predicate<Integer> p = i->i%2==0;
		System.out.println(p.test(4));
		
	
	}
}