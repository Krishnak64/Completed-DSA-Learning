class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st= new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(i);
            }
            else if(ch == ')') {
                if(!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    st.pop();
                } else{
                    st.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--) {
            if(!st.isEmpty() && st.peek() == i) {
                st.pop();
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.reverse().toString();
    }
}