class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            map.put(ch, i); 
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}