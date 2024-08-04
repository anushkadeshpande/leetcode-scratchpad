class Solution {
    public int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i > grid.length -1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0 || grid[i][j] == -1)
            return 0;
        
        // mark current cell as visited
        grid[i][j] = -1;

        return 1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    area = dfs(grid, i, j);
                    
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
}