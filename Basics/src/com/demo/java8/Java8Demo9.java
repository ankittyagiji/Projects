package com.demo.java8;
import java.util.function.Consumer;

public class Java8Demo9 {
	
	public static void main(String[] args) {
		
		Consumer<String> cc = s -> System.out.println(s);
		
		cc.accept("Durga");
	}

}
