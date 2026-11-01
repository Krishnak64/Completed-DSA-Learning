class Solution {
    public int res(int n, int[] dp) {
        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = res(n-1, dp) + res(n-2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return res(n, dp); 
    }
}