class Solution {
    public int numIslands(char[][] grid) {
        // traverse through the grid
        // if grid[i][j] == 1, perform dfs and mark the cells as visited
        // do not revisit a cell
        int numIslands = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    // dfs
                    // root == grid[i][j]
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == 'v') {
            // numIslands++;
            return;
        }
        
        // mark current cell as visited
        grid[i][j] = 'v';
        
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}