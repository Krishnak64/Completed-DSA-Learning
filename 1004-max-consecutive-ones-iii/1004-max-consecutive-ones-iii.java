class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < n; right++) {
            int currentEle = nums[right];
            map.put(currentEle, map.getOrDefault(currentEle, 0) + 1);

            int zeros = map.getOrDefault(0, 0);

            while(zeros > k) {
                int previouseEle = nums[left];
                map.put(previouseEle, map.getOrDefault(previouseEle, 0) - 1);
                left++;
                zeros = map.getOrDefault(0, 0);
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}