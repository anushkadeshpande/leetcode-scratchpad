class Solution {
    
    int[][] dp;
    
//     public int getMinCoins(int[] coins, int n, int amount) {
//         if(dp[n][amount] != -1)
//             return dp[n][amount];
        
//         if(coins[n-1] <= amount) 
//             dp[n][amount] = Math.min(1 + getMinCoins(coins, n, amount-coins[n-1]), getMinCoins(coins, n-1, amount));
//         else
//             dp[n][amount] = getMinCoins(coins, n-1, amount);
        
//         return dp[n][amount];
//     }
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=amount; j++) {
                if(j == 0)
                    dp[i][j] = 0;
                else if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                else {
                    if(coins[i-1] <= j)
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        // int numCoins = getMinCoins(coins, coins.length, amount);
        
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }
}