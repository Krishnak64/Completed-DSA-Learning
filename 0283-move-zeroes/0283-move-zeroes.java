class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int j = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                zeros++;
            } else {
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i=j; i<n; i++){
            nums[i] = 0;
        }
    }
}