class Solution {
    int[][] prefix;

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // compute prefix matrix
        prefix = new int[m][n];

        computePrefix(mat, m, n);

        int bestSide = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // check for all offsets
                int maxPossibleLength = Math.min(m-i, n-j);
                for(int k=0; k<maxPossibleLength; k++) {
                    int val = findSum(i, j, i+k, j+k);

                    if(val <= threshold) {
                        bestSide = Math.max(bestSide, k+1);
                    } else
                        break; // no need to check for further values
                }
            }
        }

        return bestSide;
    }

    void computePrefix(int[][] mat, int m, int n) {
        // prefix[0][0] = mat[0][0];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                prefix[i][j] = (i > 0? prefix[i-1][j] : 0 ) + (j > 0 ? prefix[i][j-1] : 0) -
                                ((i > 0 && j > 0) ? prefix[i-1][j-1]:0) + mat[i][j];
            }
        }
    }

    int findSum(int r1, int c1, int r2, int c2) {
        int sum = 0;
        // for(int i=r1; i<=r2; i++) {
        //     for(int j=c1; j<=c2; j++) {
        //         sum += mat[i][j];
        //     }
        // }

        return prefix[r2][c2] 
            - (r1 > 0? prefix[r1-1][c2] : 0)
            - (c1 > 0? prefix[r2][c1-1] : 0) 
            + (r1 > 0 && c1> 0? prefix[r1-1][c1-1] : 0);
    }
}