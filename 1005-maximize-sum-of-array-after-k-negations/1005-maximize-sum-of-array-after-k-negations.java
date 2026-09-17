class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        int count = 1;
        int arr[] = new int[n];
        Arrays.sort(nums);


        for (int i = 0; i < n; i++) {

            if (nums[i] < 0 && count <= k) {
                arr[i] = -nums[i];
                count++;
            } 
            else {
                arr[i] = nums[i];
            }
        }

        Arrays.sort(arr);

        if ((k - count + 1) % 2 == 1) {
            arr[0] = -arr[0];
        }

        int sum = 0;
        for(int x : arr) {
            sum += x;
        }

        return sum;
    }
}