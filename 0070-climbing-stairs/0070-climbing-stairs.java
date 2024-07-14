class Solution {
    int[] dp;
    
    public int getNumWays(int n) {
        if(n == 0)
            return 1;
        
        if(n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        dp[n] = getNumWays(n-1) + getNumWays(n-2);
        return dp[n];
    }
    
    public int climbStairs(int n) {
        dp = new int[n+1];
        for(int i=0; i<=n; i++)
            dp[i] = -1;
        
        return getNumWays(n);
    }
}