class CustomStack {
    
    List<Integer> stack;
    int size;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        size = maxSize;
    }
    
    public void push(int x) {
        if(stack.size() < size) {
            stack.add(x);
        }
    }
    
    public int pop() {
        if(stack.size() > 0) {
            return stack.remove(stack.size() - 1);
        } else
            return -1;
    }
    
    public void increment(int k, int val) {
        int n = stack.size();
        int i = 0;
        while(i < n && k > 0) {
            stack.set(i, stack.get(i)+val);
            i++;
            k--;
        }
        
        // for(int num: stack) {
        //     System.out.print(num + " ");
        // }
        // System.out.println("");
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */