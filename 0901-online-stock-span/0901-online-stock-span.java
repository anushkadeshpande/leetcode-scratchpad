class StockSpanner {
    Stack<Integer> stack;
    List<Integer> arr;
    
    public StockSpanner() {
        stack = new Stack();
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
        int ans = 1;
        arr.add(price);
        
        while(!stack.empty() && arr.get(stack.peek()) <= price)
            stack.pop();

        ans = arr.size() - (!stack.empty() ? stack.peek() + 1 : 0); 
        
        stack.push(arr.size() - 1); 
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */