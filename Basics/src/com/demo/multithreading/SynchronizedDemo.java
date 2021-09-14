package com.demo.multithreading;

class Display{
	public void wish(String name) {
		for(int i=0;i<10;i++) {
			System.out.println("Good  morning ==> " + Thread.currentThread().getName()+" "+name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(name);
			}
		}
	}
}

class MyThread2 extends Thread{
	Display d;
	String name;
	
	MyThread2(Display d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run() {
		d.wish(name);
	}
	
}
public class SynchronizedDemo {
	public static void main(String[] args) {
		Display d1 = new Display();
		Display d2 = new Display();
		MyThread2 t1 = new MyThread2(d1, "Ankit");
		MyThread2 t2 = new MyThread2(d2, "Sidd");
		t1.start();
		t2.start();
	}

}
