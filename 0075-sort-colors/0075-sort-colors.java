class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                count0++;
            } else if(nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int i=0;
        for(int j=0; j<count0; j++) {
            nums[i++] = 0;
        }

        for(int j=0; j<count1; j++) {
            nums[i++] = 1;
        }

        for(int j=0; j<count2; j++) {
            nums[i++] = 2;
        }
    }
}