class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0;
        int end = n - 1;
        int res[] = new int[2];

        while(start < end) {
            int sum = numbers[start] + numbers[end];

            if(sum > target) {
                end--;
            }

            if(sum < target) {
                start++;
            }

            if(sum == target) {
                res[0] = start+1;
                res[1] = end+1;
                return res;
            }
        }
        return res;
    }
}