class Solution {
    
    int[] dp;
    
    public int getMinCostClimb(int[] cost, int idx) {
        if(idx >= cost.length)
            return 0;
         
        if(dp[idx] != -1)
            return dp[idx];
        // pay and climb one step
        int oneStepCost = cost[idx] + getMinCostClimb(cost, idx + 1);
        
        // pay and climb 2 steps
        int twoStepCost = cost[idx] + getMinCostClimb(cost, idx+2);
        
        dp[idx] = Math.min(oneStepCost, twoStepCost);
        
        return dp[idx];
    }
    
    public int minCostClimbingStairs(int[] cost) {
        // at every step, we either climb it or skip it
        
        dp = new int[cost.length + 1];
        for(int i=0; i<=cost.length; i++) {
            dp[i] = -1;
        }
        return Math.min(getMinCostClimb(cost, 0), getMinCostClimb(cost, 1));
    }
}