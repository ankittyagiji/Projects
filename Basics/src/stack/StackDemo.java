package stack;

public class StackDemo {

	public static void main(String[] args) {
		
		Stack1 s = new Stack1();
		s.push(10);
		s.push(20);
		s.push(320);
		s.push(40);
		s.pop();
		
	}
	}


class Stack1 {
	static final int MAX=1000;
	int top;
	
	int a[] = new int[MAX];
	
	boolean isEmpty()
	{
		return (top<0);
	}
	
	Stack1()
	{
		top=-1;
	}

	boolean push(int x)
	{
		if(top>=(MAX-1))
		{
			System.out.println("Stack Overflow");
		return false;
		}
		else
		{
			a[++top] = x;
			System.out.println(x + "pushed  into  stack");
			return true;
		}
		
	}
	
	
	int pop()
	{
		if(top<0)
		{
			System.out.println("Stack overflow");
			return 0;
		}
		
		else
		{
			int x=a[top--];
			System.out.println(x + "popped  from  stack");
			return x;
		}
	}
	
	
	int peek()
	{
		if(top<0)
		{
			System.out.println("Stack overflow");
			return 0;
		}
		
		else
		{
			int x = a[top];
			return x;
		}
		
	}
	
 }