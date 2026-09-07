class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];

        for(int i=1; i<n; i++) {
            res[i] = nums[i] + res[i - 1];
        }

        int ans = 0;

        if(res[k-1] / k >= threshold) {
            ans++;
        }

        int sum = 0;

        for(int i=k; i<n; i++) {
            sum= res[i] - res[i - k];
            if(sum / k >= threshold) {
                ans++;
            }
        }

        return ans;
    }
}