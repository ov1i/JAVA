package mypkg;

import java.util.Scanner;

/*
 * Implement the already known sorting algorithms (bubble sort, insertion sort, quick sort, etc.) and apply them
 * upon an array of integer variables read from the keyboard.
 */

public class OvidiuGherman_Lab03_p5 {

	static void printResult(String sort_method, int[] arr) {
		System.out.print("\nThe result of " + sort_method + " is: ");
		for(int i = 0;i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void bubble_sort(int[] arr) {
		int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] < arr[j + 1]) {                   
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
	}
	
	
	  static int q_part_sort(int arr[], int low, int high)
	    {
	        int pivot = arr[high];
	        int i = (low-1);
	        for (int j=low; j<high; j++)
	        {

	            if (arr[j] <= pivot)
	            {
	                i++;
	 
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	 
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	 
	        return i+1;
	    } 
	 
	    static void quick_sort(int arr[], int low, int high)
	    {
	        if (low < high)
	        {
	            int p = q_part_sort(arr, low, high);
	 
	            quick_sort(arr, low, p-1);
	            quick_sort(arr, p+1, high);
	        }
	    }
	    
	
	public static void main(String[] args) {
		int arr[];
		int n;
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the array: ");
		n = scanner.nextInt();
		
		arr = new int[n];
		
		System.out.print("Please enter the values of the array: ");
		for(int i = 0;i < n;i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		
		quick_sort(arr,0,n-1);
		printResult("QuickSort", arr);
		
		bubble_sort(arr);
		printResult("BubbleSort", arr);
		
		
			
	}

}
