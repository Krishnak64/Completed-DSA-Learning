class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                sum += nums[j];
                if(sum == goal) {
                    ans++;
                }
            }
            sum = 0;
        }

        return ans;
    }
}