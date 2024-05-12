class StockSpanner {
    Stack<Integer> stack = new Stack();
    List<Integer> arr = new ArrayList<>();
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int ans = 1;
        arr.add(price);
        
        while(!stack.empty() && arr.get(stack.peek()) <= price)
            stack.pop();

        ans = arr.size() - (stack.size() > 0 ? stack.peek() + 1 : 0); 
        
        stack.push(arr.size() - 1); 
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */