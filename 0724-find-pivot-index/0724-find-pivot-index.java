class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefSum = new int[n];

        prefSum[0] = nums[0];

        for(int i=1; i<n ;i++) {
            prefSum[i] = prefSum[i-1] + nums[i];
        }

        int[] postSum = new int[n];

        postSum[n-1] = nums[n-1];

        for(int i=n-2; i>=0 ;i--) {
            postSum[i] = postSum[i+1] + nums[i];
        }

        for(int i=0; i<n; i++) {
            int left = i==0 ? 0 : prefSum[i - 1];
            int right = i==n-1 ? 0 : postSum[i+1];

            if(left == right) {
                return i;
            }
        }

        return -1;
    }
}