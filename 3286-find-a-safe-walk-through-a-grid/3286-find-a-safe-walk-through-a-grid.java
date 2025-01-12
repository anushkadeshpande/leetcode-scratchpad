class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // we start with 0,0
        // need to reach to the end
        int rows = grid.size();
        int cols = grid.get(0).size();

        // let's store the maximum health that can be achieved at the cell instead of boolean visited
        // so instead of visiting and then unvisiting a cell, record the health at that point, and visit the cell again only if the health is gonna increase
        int[][] visited = new int[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++)
                visited[i][j] = -1;
        }

        return traverse(grid, 0, 0, health, rows, cols, visited);
    }
    
    public boolean traverse(List<List<Integer>> grid, int i, int j, int health, int m, int n, int[][] visited) {
        if(health <= 0 || i < 0 || i >= m || j < 0 || j >= n)
            return false;
        
        int currentVal = grid.get(i).get(j);
        
        if(i == m-1 && j == n-1 && health - currentVal > 0)
            return true;

        boolean ans = false;
        
        health = health - currentVal;

        if(visited[i][j] < health) {
            visited[i][j] = health;

            
            ans = traverse(grid, i-1, j, health, m, n, visited) || traverse(grid, i+1, j, health, m, n, visited) || traverse(grid, i, j-1, health, m, n, visited) || traverse(grid, i, j+1, health, m, n, visited);
        
        // visited[i][j] = false;
        }
        return ans;
    }
}