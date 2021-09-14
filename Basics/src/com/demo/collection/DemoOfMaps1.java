package com.demo.collection;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class DemoOfMaps1 {
	public static void main(String[] args) {

		Map<String, String> map2 = extracted();
		//System.out.println(map2.get("c"));
		System.out.println(map2);
	}

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	private static Map<String, String> extracted() {
		Map<String, String> map1 = new TreeMap<String, String>();

		map1.put("a", "Ankit");
		map1.put("", "");
		map1.put("", "");
		map1.put("b", "Ankit");
		map1.put("c", "Shivam");
		map1.put("c", "Zebra");
		map1.put("c", "Ziibra");

		for (@SuppressWarnings("unused") Map.Entry<String, String> entry : map1.entrySet()) {
			if (map1.entrySet().contains("")) {
				return (Map<String, String>) Collections.emptyList();
			}
		}
		return map1;
	}

}
