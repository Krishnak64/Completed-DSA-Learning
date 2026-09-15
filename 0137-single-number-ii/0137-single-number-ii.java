class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> keys = map.keySet();
        int ans = 0;

        for(Integer key : keys) {
            if(map.get(key) == 1) {
                ans = key;
                break;
            }
        }

        return ans;

    }
}