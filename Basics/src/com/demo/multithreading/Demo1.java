package com.demo.multithreading;
//Thread.yield will give main thread more chance to complete first.
class MyThread extends Thread{
	@Override
	public void run()
	{
		for(int i=0;i<10;i++) {
			System.out.println("Child  Thread");
			Thread.yield();
		}
	}
}

public class Demo1 {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		for(int j=0;j<10;j++) {
			System.out.println("Main Thread");
			
		}
	}

}
