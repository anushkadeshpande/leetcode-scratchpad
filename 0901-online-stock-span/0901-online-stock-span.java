class StockSpanner {
    class Span {
        int price;
        int idx;
        
        public Span(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
        
        public int getPrice() {
            return this.price;
        }
        
        public int getIdx() {
            return this.idx;
        }
    }
    
    Stack<Span> stack;
    int size;
    
    public StockSpanner() {
        stack = new Stack();
        size = 0;
    }
    
    public int next(int price) {
        int ans = 1;
        size ++;
        
        while(!stack.empty() && stack.peek().getPrice() <= price)
            stack.pop();

        ans = size - (!stack.empty() ? stack.peek().getIdx() + 1 : 0); 
        
        stack.push(new Span(price, size-1)); 
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */