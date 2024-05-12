class StockSpanner {
    class Span {
        int price;
        int span;
        
        public Span(int price, int span) {
            this.price = price;
            this.span = span;
        }
        
        public int getPrice() {
            return this.price;
        }
        
        public int getSpan() {
            return this.span;
        }
    }
    
    Stack<Span> stack;
    
    public StockSpanner() {
        stack = new Stack();
        // size = 0;
    }
    
    public int next(int price) {
        int ans = 1;
        // size ++;
        
        while(!stack.empty() && stack.peek().getPrice() <= price)
            ans += stack.pop().getSpan();

        // ans = size - (!stack.empty() ? stack.peek().getIdx() + 1 : 0); 
        
        stack.push(new Span(price, ans)); 
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */