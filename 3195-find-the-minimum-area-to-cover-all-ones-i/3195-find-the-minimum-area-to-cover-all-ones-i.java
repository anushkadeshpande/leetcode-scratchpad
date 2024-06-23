class Solution {
    public int minimumArea(int[][] grid) {
        // consider it as a tree
        // we can choose to travel an edge or not
        
        // do we need number of ones in the matrix??
        // Set<Integer> rows = new HashSet<>();
        // Set<Integer> cols = new HashSet<>();
        
        int maxRow = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        int onesCount = 0;
        
        if(grid.length == 1 && grid[0].length == 1) {
            if(grid[0][0] == 1)
                return 1;
            return 0;
        }
        
        boolean rowHasOne = false;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    
                    maxRow = Math.max(maxRow, i);
                    
                    minCol = Math.min(minCol, j);
                    
                    maxCol = Math.max(maxCol, j);                    
                }
            }
        }
    
        
        int area = (maxRow - minRow + 1) * (maxCol - minCol + 1);
        
        return area;
        
    }
}