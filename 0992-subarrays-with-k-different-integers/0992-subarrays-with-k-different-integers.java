class Solution {
    public int atMost(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for(int right=0; right<n; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += right - left + 1; 
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
}