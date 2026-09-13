class Solution {
    public int atMost(int[] nums, int goal) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        int left = 0;
        for(int right=0; right<n; right++) {
            sum += nums[right];

            while(sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1; 
        }

        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}