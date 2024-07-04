class Solution {
    
    int dp[][];
    
    public int minDifference(int[] arr, int n, int target, int sum) {
        if(n < 0)
            return Math.abs(target - sum);
        
        if(dp[n][target] != -1)
            return dp[n][target];
        
        int take = minDifference(arr, n-1, target-arr[n], sum + arr[n]);
        
        int notTake = minDifference(arr, n-1, target, sum);
        
        dp[n][target] = Math.min(take, notTake);
        
        return dp[n][target];
    }
    
    public int lastStoneWeightII(int[] stones) {
        // same as minimum subset sum difference
        
        // basically we need to split the array in such a way that the difference between the sum of both subsets is minimum
        
        // find the sum of the entire array
        int sum = 0;
        int n = stones.length;
        
        for(int i=0; i<n; i++)
            sum += stones[i];
        
        dp = new int[n+1][sum+1];
        
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                dp[i][j] = -1; 
            }
        }
        
        return minDifference(stones, n - 1, sum, 0);
    }
}