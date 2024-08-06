class neighborSum {
    int rows;
    int cols;
    
    Map<Integer, String> positionMap = new HashMap<>();
    int[][] grid;
        
    public neighborSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                positionMap.put(grid[i][j], i + ":" + j);
            }
        }
    }
    
    public int adjacentSum(int value) {
        String pos = positionMap.get(value);
        String x[] = pos.split(":");
        
        int r = Integer.valueOf(x[0]);
        int c = Integer.valueOf(x[1]);
        int sum = 0;
        
        if(r-1 >= 0)
            sum += grid[r-1][c];
        if(r+1 < rows)
            sum += grid[r+1][c];
        if(c-1 >= 0)
            sum += grid[r][c-1];
        if(c+1 < cols) 
            sum += grid[r][c+1];
        
        return sum;
    }
    
    public int diagonalSum(int value) {
                String pos = positionMap.get(value);
        String x[] = pos.split(":");
        
        int r = Integer.valueOf(x[0]);
        int c = Integer.valueOf(x[1]);
        int sum = 0;
        
        if(r-1 >= 0 && c-1 >= 0)
            sum += grid[r-1][c-1];
        if(r+1 < rows && c+1 < cols)
            sum += grid[r+1][c+1];
        if(r-1 >= 0 && c+1 < cols)
            sum += grid[r-1][c+1];
        if(r+1 < rows && c-1 >= 0) 
            sum += grid[r+1][c-1];
        
        return sum;

    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */