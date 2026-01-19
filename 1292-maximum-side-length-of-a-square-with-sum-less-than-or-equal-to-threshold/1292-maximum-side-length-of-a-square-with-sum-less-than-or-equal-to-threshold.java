class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int bestSide = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // check for all offsets
                int maxPossibleLength = Math.min(m-i, n-j);
                for(int k=0; k<maxPossibleLength; k++) {
                    int val = findSum(mat, i, j, i+k, j+k);

                    if(val <= threshold) {
                        bestSide = Math.max(bestSide, k+1);
                    } else
                        break; // no need to check for further values
                }
            }
        }

        return bestSide;
    }

    int findSum(int[][] mat, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++) {
                sum += mat[i][j];
            }
        }

        return sum;
    }
}