class Solution {
    public int firstUniqChar(String s) {
        int charCount[] = new int[26];
        int n = s.length();
        int ans = -1;
        Arrays.fill(charCount, 0);

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(charCount[ch - 'a'] == 0) {
                charCount[ch - 'a'] = 1;
            } else {
                charCount[ch - 'a'] = charCount[ch - 'a'] + 1;
            }
        }

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(charCount[ch - 'a'] == 1) {
                ans = i;
                return ans;
            }
        }
        return ans;
    }
}