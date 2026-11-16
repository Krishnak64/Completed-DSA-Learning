class Solution { 
    public boolean solve(int nums[], int i, int tar, Boolean[][] dp) { 
        if (tar == 0) return true;
        if (i >= nums.length) return false;

        if (dp[i][tar] != null) return dp[i][tar];

        boolean take = false;

        if (nums[i] <= tar) {
            take = solve(nums, i + 1, tar - nums[i], dp);
        }

        boolean skip = solve(nums, i + 1, tar, dp);

        dp[i][tar] = take || skip;
        return dp[i][tar]; 
    } 

    public boolean canPartition(int[] nums) { 
        int n = nums.length; 
        int sum = 0; 

        for (int i = 0; i < n; i++) {
            sum += nums[i]; 
        } 

        if (sum % 2 != 0) {
            return false; 
        } 

        int target = sum / 2; 
        Boolean[][] dp = new Boolean[n][target + 1]; 

        return solve(nums, 0, target, dp); 
    } 
}