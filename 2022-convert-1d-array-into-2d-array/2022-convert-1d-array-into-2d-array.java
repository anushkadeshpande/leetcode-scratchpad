class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
       
        int idx = 0;
        int originalSize = original.length;
        
        if(originalSize != m*n)
            return new int[0][0];
        
         int[][] twoDArray = new int[m][n];
        
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         twoDArray[i][j] = original[idx++];
        //     }
        // }
        for(int i=0; i<originalSize; i++) {
            twoDArray[i/n][i%n] = original[i];
        }
        
        return twoDArray;
    }
}