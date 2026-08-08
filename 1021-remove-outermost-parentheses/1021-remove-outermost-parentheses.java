class Solution {
    public String removeOuterParentheses(String s) {
        int c=1, x=1;
        String s1 = new String();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                c++;
            } else {
                c--;
            }

            if(c == 1) {
                s1 = s1 + s.substring(x, i);
                x = i + 2; 
            }
        }
        return s1;
    }
}