package com.demo.java8;
import java.util.function.Predicate;

public class Java8Demo7 {
	public static void main(String[] args) {
		
		int[] x = {0,5,10,15,20,25};
		
		Predicate<Integer> p1 = x1 -> x1%2==0;
		Predicate<Integer> p2 = x2 -> x2>10;
		
		System.out.println("The no which are greater  than  10  and are even");
		
		for(int x2 : x)
		{
			if(p1.and(p2).test(x2))
			{
				System.out.println(x2);
			}
		}
		
		
	}

}