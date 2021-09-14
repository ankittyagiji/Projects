package com.demo.logicalPrograms;

//Brute Force is  applied  here
//it  will  not  give  correct  answer  if  there  are  more  than  2  duplicates

public class FindDuplicateInArray {
	
	public static void main(String[] args) {
		
		int a[] = {2,2,3,4,4,5};
		int l = a.length;
		
		System.out.println("Duplicates  elements  are:-------");
		
		for(int i=0;i<l-1;i++)
		{
			for(int j=i+1;j<l;j++)
			{
				if((a[j]==a[i]) && i!=j)
				{
				System.out.println(a[j]);
					
				}
				
			}
			
		}
	}

}