class Solution {
    int[][] dp;
    
    public int getMinWays(int[]coins, int amount, int n) {
        if(amount == 0)
            return 1;
        
        if(amount < 0 || n <= 0) {
            return 0;
        }
        
        if(dp[n][amount] != -1)
            return dp[n][amount];
        
        dp[n][amount] = getMinWays(coins, amount-coins[n-1], n) + getMinWays(coins, amount, n-1);
        
        return dp[n][amount];
    }
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        dp = new int[n+1][amount+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=amount; j++) {
                if(j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        } 
        
        return getMinWays(coins, amount, n);
    }
}