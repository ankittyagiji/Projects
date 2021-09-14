package com.demo.logicalPrograms;
import java.util.Scanner;

public class CountNoOfWordsInString {
	
	public static void countWords(String str) {
	
		int l=str.length();
		char array[] = new char[l];
		array= str.toCharArray();
		System.out.println(array);
		int i=0,c=0,lastIndex=0;
		String s="";
		
		for(i=0;i<l;i++)
		{
		    if(str.charAt(i)!=' ')
		      {
			    s=s+str.charAt(i);
			    lastIndex=i;
		      }
		    
		   else 
		      {
		    	    c=c+1;
		    	 
		    	 System.out.println("Length of word "+s+" --->"+s.length());
		    	 s="";
		       }
		
	    }
		if(lastIndex==(l-1))
		{
			System.out.println("Length of last word "+s+" "+s.length());
		}
		
		System.out.println("Total Words in String --> "+(c+1));
}
	
	
	public static void main(String[] args) {
		
		System.out.println("Enter the string");
		Scanner scanner  = new Scanner(System.in);
		
		String str = scanner.nextLine();
		countWords(str);
		scanner.close();
	}

	

}