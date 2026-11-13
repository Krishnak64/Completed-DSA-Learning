class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);
        int[] p = new int[n]; 
        p[0] = 1;

        for(int i=1; i<n; i++) {
            p[i] = (p[i-1]*2) % mod;
        }

        int l = 0, r = n - 1;
        int res = 0;

        while(l <= r) {
            if(nums[l] + nums[r] <= target) {
                res = (res + p[r-l]) % mod;
                l++;
            }
            else {
                r--;
            }
        }

        return res;
    }
}