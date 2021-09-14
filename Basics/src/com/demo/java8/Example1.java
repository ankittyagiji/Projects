package com.demo.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

	public static void main(String[] args) {

		String[] names = { "Ankit", "Siddharth", "Swatantra", "Savita", "Abhishek" };

		List<String> list = Stream.of(names).filter(x -> x.startsWith("A")).sorted().collect(Collectors.toList());

		System.out.println(list);
		
		boolean b = Stream.of(names).anyMatch(x->x.equals("Ankit"));
		System.out.println(b);

		Integer[] a1 = { 1, 2, 3, 4, 5 };

		List<Integer> intList = Stream.of(a1).map(x -> x * x).collect(Collectors.toList());
		System.out.println(intList);

		Stream.of(a1).map(x -> x * x).forEach(System.out::println);

		 String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		  List<String> collect = Stream.of(array)     // Stream<String[]>
		          .flatMap(Stream::of)                // Stream<String>
		          .filter(x -> !"a".equals(x))        // filter out the a
		          .collect(Collectors.toList());      // return a List

		  collect.forEach(System.out::println);
		
		  
		// Creating a Stream of Strings
	        Stream<String> stream = Stream.of("Geeks", "for",
	                                          "GEEKSQUIZ", "GeeksforGeeks");
	  
	        // Check if Character at 1st index is
	        // UpperCase in any string or not using
	        // Stream anyMatch(Predicate predicate)
	        boolean answer = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1)));
	  
	        // Displaying the result
	      System.out.println(answer);
		
		
	}
}
