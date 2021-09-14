package com.demo.arrays;

public class ProgramToFindSmallestLargest {
	public static void main(String[] args) {
		int array[] = { 12, 11, 3, 5, 10 };
		findLargestAndSmallest(array);
	}

	public static void findLargestAndSmallest(int array[]) {

		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;

		System.out.println("Integer Max value is ====> " + largest);
		System.out.println("Integer Min value is ====> " + smallest);

		for(int element : array) {

			if (element > largest)
			{
				largest = element;
			}
			else if (element < smallest)
			{
				smallest = element;
			}
			System.out.println("Integer Max value is ====> " +largest);
			System.out.println("Integer Min value is ====> " +smallest);

		}
		System.out.println("Integer Max value is ====> " + largest);
		System.out.println("Integer Min value is ====> " + smallest);

	}

}
