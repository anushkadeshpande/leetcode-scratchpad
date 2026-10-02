class Solution {
    int [][][] dp;

    public int numberOfPaths(int[][] grid, int k) {
        dp = new int[grid.length][grid[0].length][k];

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                for(int z=0; z<k; z++)
                    dp[i][j][z] = -1;
            }
        }
        return traverse(grid, 0, 0, k, 0);
    }

    public int traverse(int[][] grid, int i, int j, int k, int sum) {

        if(i >= grid.length || j >= grid[0].length)
            return 0;

        sum = (sum + grid[i][j]) % k;

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            if(sum == 0) {
                return dp[i][j][sum] = 1;
            }
            return dp[i][j][sum] = 0;
        }

        if(dp[i][j][sum] != -1)
            return dp[i][j][sum];

        return dp[i][j][sum] = (traverse(grid, i+1, j, k, sum) + traverse(grid, i, j+1, k, sum)) % (1000000007); 
    }
}