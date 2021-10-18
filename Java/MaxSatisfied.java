package arrays;

public class MaxSatisfied {

	public static void main(String[] args) {
		int customers[] = { 1,0,1,2,1,1,7,5};
		int grumpy[] = {0,1,0,1,0,1,0,1};
		int minutes = 3;
		int res = maxSatisfied(customers,grumpy,minutes);
		System.out.println(res);

	}
	 public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
	        int satisfied = 0, maxMakeSatisfied = 0;
	        for (int i = 0, winOfMakeSatisfied = 0; i < grumpy.length; ++i) {
	            if (grumpy[i] == 0) { satisfied += customers[i]; }
	            else { winOfMakeSatisfied += customers[i]; }
	            if (i >= X) {
	                winOfMakeSatisfied -= grumpy[i - X] * customers[i - X];
	            }
	            maxMakeSatisfied = Math.max(winOfMakeSatisfied, maxMakeSatisfied);
	        }
	        return satisfied + maxMakeSatisfied;        
	    }

}
// This is the solution program of the Leetcode problem no. 1052. Grumpy Bookstore Owner
//link: https://leetcode.com/problems/grumpy-bookstore-owner/