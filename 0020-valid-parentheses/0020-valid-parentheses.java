class Solution {
    public boolean isValid(String s) {
        Stack<Character> k = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                k.push(c);
            }
            else {
                if(k.isEmpty()) {
                    return false;
                } 
               
                if((k.peek() == '(' && c == ')') || (k.peek() == '[' && c == ']') || (k.peek() == '{' && c == '}')) {
                    k.pop();
                }
                else {
                    return false;
                }
                
            }            
        } 
        if(k.isEmpty()) {
            return true;
        }

        return false;
    }
}