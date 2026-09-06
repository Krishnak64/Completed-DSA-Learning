class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];

        for(int i=1; i<n; i++) {
            res[i] = nums[i] + res[i - 1];
        }

        int maxSum = res[k-1];
        int max = 0;

        for(int i=k; i<n; i++) {
            max= res[i] - res[i - k];
            maxSum = Math.max(maxSum, max);
        }

        return (double)maxSum / k;
    }
}