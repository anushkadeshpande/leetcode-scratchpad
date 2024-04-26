class Solution {
    public int helper(int[][] grid, int i, int j , Integer[][] dp , int n) 
    {
        if(j >= n || i >= n)
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        if(i == n - 1)
            return grid[i][j];
        int value = Integer.MAX_VALUE;
        for(int k = 0 ; k < n ; k++)
        {
            if(k != j)
            {
                value = Math.min(value , helper(grid , i + 1, k , dp , n));
            }
        }
        return dp[i][j] = grid[i][j] + value;
    }
    public int minFallingPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        int ans = Integer.MAX_VALUE;
        int n = grid.length;
        for(int i = 0 ; i < n ; i++)
        {
            ans = Math.min(ans , helper(grid , 0 , i , dp , n));
        }
        return ans;
    }
   
}