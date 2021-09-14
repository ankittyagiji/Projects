package com.demo.logicalPrograms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<Integer>();
		long st1=System.currentTimeMillis();  
		for(int i=0;i<10000;i++)
		{
			al.add(i);
		}
		
		long end1 = System.currentTimeMillis();
		System.out.println("Time taken by ArrayList is --> "+(end1-st1));
		
		List<Integer> ll = new LinkedList<Integer>();
		long st2=System.currentTimeMillis();  
		for(int i=0;i<10000;i++)
		{
			ll.add(i);
		}
		
		long end2 = System.currentTimeMillis();
		System.out.println("Time taken by LinkedList is --> "+(end2-st2));
		
	}

}