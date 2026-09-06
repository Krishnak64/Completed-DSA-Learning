class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = n - 1;

        while(start < end) {
            char startC = s.charAt(start);
            char endC = s.charAt(end);

            if(!Character.isLetterOrDigit(startC)) {
                start++;
                continue;
            }

            if(!Character.isLetterOrDigit(endC)) {
                end--;
                continue;
            }


            if(Character.toLowerCase(startC) != Character.toLowerCase(endC)) {
                return false;
            }
            else {
                start++;
                end--;
            }
        }

        return true;
    }
}