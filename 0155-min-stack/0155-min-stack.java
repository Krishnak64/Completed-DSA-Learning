class MinStack {
    Stack<Long> s = new Stack<>();
    long min = -1;
    public MinStack() {
        
    }
    
    public void push(int value) {
        long x = (int)value;
        if(s.size() == 0) {
            s.push(x);
            min = x;
        }
        else if(x>=min) {
            s.push(x);
        } else {
            s.push(2*x - min);
            min = x;
        }
    }
    
    public void pop() {
        if(s.size() == 0) {
            return;
        } else if(s.peek() >= min) {
            s.pop();
        } else {
            long old = 2*min - s.peek();
            min = old;
            s.pop();
        }
    }
    
    public int top() {
        if(s.size() == 0) {
            return -1;
        } 
        long q = s.peek();

        if(q >= min) {
            return (int)(q);
        } 
        if(q < min) {
            return (int)min;
        }
        return 0;
    }
    
    public int getMin() {
        if(s.size() == 0) return -1;
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */