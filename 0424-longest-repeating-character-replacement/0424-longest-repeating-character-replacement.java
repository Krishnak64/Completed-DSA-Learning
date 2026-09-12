class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int arr[] = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            arr[ch - 'A']++;

            maxFreq = Math.max(maxFreq, arr[ch - 'A']);

            int minFreq = right - left + 1 - maxFreq;

            while(minFreq > k) {
                char c = s.charAt(left);
                arr[c - 'A']--;
                left++;
                minFreq = right - left + 1 - maxFreq;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}