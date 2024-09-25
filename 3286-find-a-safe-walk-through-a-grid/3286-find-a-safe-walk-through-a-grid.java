public class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] visited = new int[m][n];
        for (int[] row : visited) Arrays.fill(row, -1);  

        return dfs(grid, 0, 0, health-grid.get(0).get(0), visited);
    }

    private boolean dfs(List<List<Integer>> grid, int row, int col, int health, int[][] visited) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        if (health < 1) {
            return false;
        }

        if (row == m - 1 && col == n - 1 && health >= 1) {
            return true;
        }

        visited[row][col] = health;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                int newHealth = health - grid.get(newRow).get(newCol); 

                if (newHealth > visited[newRow][newCol]) {
                    if (dfs(grid, newRow, newCol, newHealth, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
