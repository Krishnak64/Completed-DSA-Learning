class NumArray {
    int[] prev;
    public NumArray(int[] nums) {
        int n = nums.length;
        prev = new int[n];
        prev[0] =  nums[0];
        for(int i=1; i<n; i++) {
            prev[i] = prev[i-1]  +  nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left <= 0) return prev[right];
        return prev[right] - prev[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */