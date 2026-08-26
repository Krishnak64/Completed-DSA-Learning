class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int upper = 0;
        int lower = 0;

        for(int i=0; i<n; i++) {
            char ch = word.charAt(i); 
            if(ch >= 'A' && ch <= 'Z') {
                upper++;
            } else {
                lower++;
            }
        }

        if(upper == n) {
            return true;
        }

        if(lower == n) {
            return true;
        }

        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && lower == n - 1) {
            return true;
        }

        return false;
    }
}