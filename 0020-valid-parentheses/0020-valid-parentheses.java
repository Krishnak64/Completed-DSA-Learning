class Solution {
    public boolean isValid(String s) { //T.C --> O(n)
        Stack<Character> k = new Stack<>(); 
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            // pushing onto stack
            if(ch == '(' || ch == '[' || ch =='{') {
                k.push(ch);
            }
            // if no element is in stack --- "})] " this case
            else {
                if(k.isEmpty()) {
                    return false;
                }
            
            //checking parentheses
            if((k.peek() == '(' && ch == ')')  ||  
               (k.peek() == '[' && ch == ']')  || 
               (k.peek() == '{' && ch == '}') ) {

                 k.pop();
            } else {
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