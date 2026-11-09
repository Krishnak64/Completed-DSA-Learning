class Solution {
    public static int minJumps(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1); // initialization 
        dp[n-1] = 0; /// n-1 to n-1 jumps

        for(int i=n-2; i>=0; i--) {
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++) {
                if(dp[j] != -1) {
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        
        // dp[0] -> 0 to n-1
        return dp[0];
    }
    public int jump(int[] nums) {
        return minJumps(nums);
    }
}