class Solution {
    
    int dp[][];
    
    public void subsetSum(int[] arr, int n, int target) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=target; j++) {
                if(j >= arr[i-1]) 
                    dp[i][j] = ((dp[i-1][j - arr[i-1]] == 1) || dp[i-1][j] == 1) ? 1 : 0;
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
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
                
                if(j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1; 
            }
        }
        
        subsetSum(stones, n, sum);
        
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<=sum/2; i++) {
            if(dp[n][i] == 1) {
                minDiff = Math.min(minDiff, sum - 2 * i);                
            }
        }
        
        return minDiff;
    }
}