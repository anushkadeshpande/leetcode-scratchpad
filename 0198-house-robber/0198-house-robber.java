class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 0)
            return 0;
        
        int dp[] = new int[n + 1];
        
        // we can gain 0 by robbing 0 houses
        dp[0] = 0;
         
        // nums[0] can be gained by robbing 1st house
        dp[1] = nums[0];
        
        for(int i=1; i<n; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        
        return dp[n];
    }
}