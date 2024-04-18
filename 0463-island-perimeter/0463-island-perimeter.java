class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    // if we're in the 1st row
                    if(i == 0)
                       perimeter++;
                    
                    // if we're in the last row
                    if(i == grid.length - 1)
                        perimeter++;
                    
                    // if we're in the 1st col
                    if(j == 0)
                        perimeter++;

                    // if we're in the last col
                    if(j == grid[0].length - 1)
                        perimeter++;
                    
                    // checking the square before current square
                    if(i-1 >= 0 && grid[i-1][j] == 0)
                        perimeter++;
                    if(j-1 >= 0 && grid[i][j-1] == 0)
                        perimeter++;
                    
                    // checking the square after current square
                    if(i+1 < grid.length && grid[i+1][j] == 0)
                        perimeter++;
                    if(j+1 < grid[0].length && grid[i][j+1] == 0)
                        perimeter++;
                    
                }
            }
        }
        
        return perimeter;
    }
}