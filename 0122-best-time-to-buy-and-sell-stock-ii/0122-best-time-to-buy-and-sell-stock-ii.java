class Solution {
    public int maxProfit(int[] prices) {
        // find next greater element
        // for every element, find max diff and add it to final answer
        
        Stack<Integer> stack = new Stack<>();
        
        int n = prices.length;
        
        // int[] nge = new int[n];
        
        int[] maxProfit = new int[n];
        
        for(int i=n-1; i>=0; i--) {
            maxProfit[i] = 0;
            
            while(!stack.empty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            // if(stack.empty())
                // nge[i] = -1;
            if(!stack.empty()) {
                // nge[i] = stack.peek();
                int idx = stack.peek();
                 maxProfit[idx] = Math.max(prices[idx] - prices[i], maxProfit[idx]);
            }
            
            stack.push(i);
        }
        
        int ans = 0;
        
        // for(int i=0; i<n; i++) {
        //     if(nge[i]!= -1)
        //         maxProfit[nge[i]] = Math.max(prices[nge[i]] - prices[i], maxProfit[nge[i]]);
        // }
        
        for(int i=0; i<n; i++)
            ans += maxProfit[i];
        return ans;
    }
}