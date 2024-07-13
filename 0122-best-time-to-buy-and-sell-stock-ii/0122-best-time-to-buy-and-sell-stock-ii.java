class Solution {
    int dp[][];
    
    public int maximizeProfit(int[] prices, int canBuy, int idx, int n) {
        if(idx == prices.length)
            return 0;
        if(dp[canBuy][idx] != -1)
            return dp[canBuy][idx];
        if(canBuy == 1) {
            // we have the liberty to buy, but we can choose to buy this stock or not
            dp[canBuy][idx] = Math.max(-prices[idx] + maximizeProfit(prices, 0, idx+1, n), maximizeProfit(prices, 1, idx+1, n));
        } else
            dp[canBuy][idx] = Math.max(prices[idx] + maximizeProfit(prices, 1, idx+1, n), maximizeProfit(prices, 0, idx+1, n));
        
        return dp[canBuy][idx];
    }
    
    public int maxProfit(int[] prices) {
        // find next greater element
        // for every element, find max diff and add it to final answer
        
//         Stack<Integer> stack = new Stack<>();
        
//         int n = prices.length;
        
//         int[] maxProfit = new int[n];
        
//         for(int i=n-1; i>=0; i--) {
//             maxProfit[i] = 0;
            
//             while(!stack.empty() && prices[stack.peek()] <= prices[i]) {
//                 stack.pop();
//             }
            
//             if(!stack.empty()) {
//                 int idx = stack.peek();
//                 maxProfit[idx] = Math.max(prices[idx] - prices[i], maxProfit[idx]);
//             }
            
//             stack.push(i);
//         }
        
//         int ans = 0;
        
//         for(int i=0; i<n; i++)
//             ans += maxProfit[i];
//         return ans;
        
        
        // APPROACH - 2
        int n = prices.length;
        dp = new int[3][n];
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<n; j++)
                dp[i][j] = -1;
        }
        return maximizeProfit(prices, 1, 0, n);
    }
}