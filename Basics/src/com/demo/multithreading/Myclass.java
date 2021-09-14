package com.demo.multithreading;

class Myclass {
	public static void main(String[] args) {
		Myclass t = new Myclass();
		//t.start();
		System.out.println("Main");
	}

	class Test implements Runnable {
		public void run() {
			System.out.println("Run");
		}
	}
}
/*In the above program, we will get
compile time error because start() method
is present in the Thread class only
and we are implementing Runnable interface.*/