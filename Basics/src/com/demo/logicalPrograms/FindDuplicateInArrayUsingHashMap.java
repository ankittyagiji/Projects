package com.demo.logicalPrograms;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateInArrayUsingHashMap {
	
	public static void main(String[] args) {
		int arr[]= {2,2,3,3,3,4,4,4,5,5};
		

		Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
		for(int no : arr)
		{
			Integer count = hm.get(no);
			if(count==null)
			{
				hm.put(no, 1);
			 }
			
			else
			{
				count++;
				hm.put(no, count);
			}
		}
		
		Set<Map.Entry<Integer,Integer>> es = hm.entrySet();
		
		for(Map.Entry<Integer,Integer> me : es)
		{
			if(me.getValue()>1)
			{
				System.out.println("Count of duplicate element "+me.getKey()+" is --> "+me.getValue());
			}
		}
	
	
}
}