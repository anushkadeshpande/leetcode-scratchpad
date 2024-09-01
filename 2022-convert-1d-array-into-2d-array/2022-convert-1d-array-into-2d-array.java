class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] twoDArray = new int[m][n];
        int idx = 0;
        int originalSize = original.length;
        
        if(originalSize != m*n)
            return new int[0][0];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                twoDArray[i][j] = original[idx++];
            }
                
        }
        
        return twoDArray;
    }
}