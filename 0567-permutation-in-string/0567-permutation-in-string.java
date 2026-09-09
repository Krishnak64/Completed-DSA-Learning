class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) {
            return false;
        }

        int map1[] = new int[26];

        for(int i=0; i<n; i++) {
            map1[s1.charAt(i) - 'a']++;
        }

        for(int i=0; i<=m-n; i++) {
            int map2[] = new int[26];
            for(int j=0; j<n; j++) {
                map2[s2.charAt(i+j) - 'a']++;
            }

            if(Arrays.equals(map1, map2)) {
                return true;
            }
        }

        return false;
    }
}