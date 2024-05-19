class MinStack {
    Stack<Integer> helper;
    Stack<Integer> stack;
    
    public MinStack() {
        helper = new Stack<>();
        stack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(helper.empty() || val <= helper.peek()) {
            helper.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == helper.peek())
            helper.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */