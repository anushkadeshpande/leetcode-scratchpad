class Solution {
    public int numIslands(char[][] grid) {
        // dfs
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    // dig deeper
                    recolor(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void recolor(char[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == '0' || grid[x][y] == 'V')
            return;
        if(grid[x][y] == '1') {
            grid[x][y] = 'V';
            recolor(grid, x+1, y);
            recolor(grid, x, y+1);
            recolor(grid, x-1, y);
            recolor(grid, x, y-1);
        } else return;
    }

}