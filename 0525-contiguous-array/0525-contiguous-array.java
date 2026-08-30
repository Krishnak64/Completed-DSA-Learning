class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;

        int maxlen = 0;
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if(map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxlen = Math.max(maxlen, len);
            } else {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}