package com.demo.java8;
import java.util.function.Function;

public class Java8Demo1 {
public static void main(String[] args) {
	Function<Integer, Integer> f = i->i*i;
	for(int j=1;j<=4;j++)
	{
	System.out.println("Square is :"+f.apply(j));
	}
}
}
