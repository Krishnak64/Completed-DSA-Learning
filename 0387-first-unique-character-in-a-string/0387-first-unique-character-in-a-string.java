class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        int n = s.length();
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            freq[s.charAt(i) - 'a']++;
            q.add(s.charAt(i));
        }

        while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
            q.remove();
        }

        if(q.isEmpty()) {
            return -1;
        }

        int unique = q.peek();

        for(int i=0 ; i<n; i++) {
            if(s.charAt(i) == unique) {
                return i;
            }
        }

        return -1;
    }
}