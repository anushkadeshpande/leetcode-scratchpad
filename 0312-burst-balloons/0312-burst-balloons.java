class Solution {
    public int[][] dp;
    public int getMaxCoins(List<Integer> balloons, int i, int j) {
        if(i >= j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int maxAns = Integer.MIN_VALUE;
        
        for(int k=i; k<j; k++) {
            int ans = getMaxCoins(balloons, i, k) + getMaxCoins(balloons, k+1, j) + (balloons.get(i-1) * balloons.get(k) * balloons.get(j));
            
            maxAns = Math.max(ans, maxAns);
        }
        
        dp[i][j] = maxAns;
        
        return maxAns;
    }
    
    public int maxCoins(int[] nums) {
        // same as matrix chain multiplication (but we need to return the max value)
        int n = nums.length;
        
        List<Integer> balloons = new ArrayList<>();
        balloons.add(1);
        for(int i=0; i<n; i++)
            balloons.add(nums[i]);
        balloons.add(1);
        
        n += 2;
        
        dp = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++)
                dp[i][j] = -1;
        }
        
        return getMaxCoins(balloons, 1, n-1);
    }
}