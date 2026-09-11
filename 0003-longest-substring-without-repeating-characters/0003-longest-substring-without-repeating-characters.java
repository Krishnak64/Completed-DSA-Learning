class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int ans = 0;
        for(int right=0; right<n; right++) {
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}