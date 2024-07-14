class Solution {
    
    int[] dp;
    
    public int getMinCostClimb(int[] cost, int n, int idx) {
        if(idx >= n)
            return 0;
         
        if(dp[idx] != -1)
            return dp[idx];
        // pay and climb one step
        int oneStepCost = cost[idx] + getMinCostClimb(cost, n, idx + 1);
        
        // pay and climb 2 steps
        int twoStepCost = cost[idx] + getMinCostClimb(cost, n, idx+2);
        
        dp[idx] = Math.min(oneStepCost, twoStepCost);
        
        return dp[idx];
    }
    
    public int minCostClimbingStairs(int[] cost) {
        // at every step, we either climb it or skip it
        int n = cost.length;
        dp = new int[n + 1];
        for(int i=0; i<=n; i++) {
            dp[i] = -1;
        }
        return Math.min(getMinCostClimb(cost, n, 0), getMinCostClimb(cost, n, 1));
    }
}