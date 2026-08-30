class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;

        int pref_sum = 0;
        int count = 0;

        for(int i=0; i<n; i++) {
            pref_sum += nums[i];
            int div = pref_sum % k;
            if(div < 0) {
                div = div + k;
            }
            if(map.containsKey(div)) {
                count += map.get(div);
                map.put(div, map.get(div) + 1);
            } else {
                map.put(div,  1);
            }
        }
        return count;
    }
}