class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n];
        dp[0][0] = nums[0];
        dp[1][0] = 0;

        for(int i=1; i<n; i++) {
            dp[0][i] = nums[i] + dp[1][i-1];
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
        }

        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}