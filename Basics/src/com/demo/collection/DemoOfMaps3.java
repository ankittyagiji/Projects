package com.demo.collection;

import java.util.Set;
import java.util.TreeSet;

public class DemoOfMaps3{
	public static void main(String[] args) {

		Set<String> set2 = extracted();
		//System.out.println(map2.get("c"));
		System.out.println(set2);
	}

	private static Set<String> extracted() {
		Set<String> set = new TreeSet<String>();

		set.add("Apple");
		set.add("Cat");
		set.add("");
		set.add("");
		set.add("Dog");
		set.add("Boy");
		set.add("Elephant");

		return set;
	}

}
