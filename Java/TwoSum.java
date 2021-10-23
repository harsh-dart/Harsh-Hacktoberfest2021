package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array length: ");
		int n  = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements (elements should be *Non-Decresing* order): ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter a target sum: ");
		int target = sc.nextInt();

		twoSum(arr,n,target);	
	}
	public static void twoSum(int[] arr, int n, int target) {
		int left = 0, right = n-1;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(left < right) {
			int sum = arr[left]+arr[right];
			if(sum == target) {
				res.add(left);
				res.add(right);
				break;
			} else if(sum > target) {
				right--;
			} else {
				left++;
			}
		}
		System.out.print("[");
		int ind = res.get(0);
		System.out.print(ind+1 + " ");
		ind = res.get(1);
		System.out.print(ind+1);
		System.out.println("]");
	}

}
