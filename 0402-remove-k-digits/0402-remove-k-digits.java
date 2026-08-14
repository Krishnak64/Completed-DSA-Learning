class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k > 0) {
            st.pop();
            k--;
        }

        StringBuilder s = new StringBuilder();
        int n = st.size();
        for(int i=0; i<n; i++) {
            s.insert(0, st.pop());
        }

        while(!s.isEmpty() && s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }

        return s.length() == 0 ? "0" : s.toString();
    }
}