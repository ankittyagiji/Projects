package com.demo.multithreading;
//using t2.join will make main thread wait until child thread completes
class MyThread1 extends Thread{
	@Override
	public void run()
	{
		for(int i=0;i<10;i++) {
			System.out.println("Child  Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Demo2 {
	public static void main(String[] args) throws InterruptedException {
		MyThread1 t2 = new MyThread1();
		t2.start();
		t2.join();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}

}
