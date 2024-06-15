class Solution {
    int dp[][];
    public boolean canPartitionArray(int[] arr, int n, int target) {
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=target; j++) {
                if(j >= arr[i-1])
                    dp[i][j] = (dp[i-1][j-arr[i-1]] == 1 || dp[i-1][j] == 1)? 1 : 0;
                else
                    dp[i][j] = dp[i-1][j];

            }
        }
        
        return dp[n][target] == 1;
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) 
            sum += nums[i];
        if(sum % 2 != 0)
          return false;
        
        dp = new int[nums.length+1][(sum/2) + 1];
        
        for(int i=0; i<=nums.length; i++)
            for(int j=0; j<=sum/2; j++)
                if(j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
        
        return canPartitionArray(nums, nums.length, sum/2);
    }
}