package arrays;

public class MaxSubArraySum {

	public static void main(String[] args) {
		int arr[] = {1,12,-5,-6,50,3};
		int k = 4;
		double res = findMaxAverage(arr, k);
		System.out.println(res);
	}

	private static double findMaxAverage(int[] nums, int k) {
		double currSum = 0;
        int n = nums.length;
        for(int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        double maxAvgSum = currSum/k;
        for(int i = k; i < n; i++) {
            currSum+=(nums[i]-nums[i-k]);
            maxAvgSum = Math.max(maxAvgSum,currSum/k);
        }
        return maxAvgSum;
	}

}
