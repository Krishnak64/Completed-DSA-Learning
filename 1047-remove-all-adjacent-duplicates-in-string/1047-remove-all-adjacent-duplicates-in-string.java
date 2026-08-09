class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        //Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<n;i++) {
            char curr  = s.charAt(i);
            char prev  = (res.length() == 0) ? '$' : res.charAt(res.length() - 1);

            if(curr != prev)
                res.append(curr);
            else
                res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }
}