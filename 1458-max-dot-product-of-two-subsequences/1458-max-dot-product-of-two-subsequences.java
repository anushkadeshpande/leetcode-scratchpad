class Solution {
    
    int[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        // product of everything with everything
        // find max elements in the matrix 
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = Integer.MAX_VALUE;

        return findMaxProduct(nums1, nums2, m, n, 0, 0);
    }

    public int findMaxProduct(int[] nums1, int[] nums2, int m, int n, int i, int j) {
        if(i >= m || j >= n)
            return Integer.MIN_VALUE;

        if(dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        int ans = Integer.MIN_VALUE;

        // take or skip current pair
        ans = Math.max(ans, nums1[i] * nums2[j] + Math.max(0, findMaxProduct(nums1, nums2, m, n, i+1, j+1)));

        // keep j constant
        ans = Math.max(ans, findMaxProduct(nums1, nums2, m, n, i+1, j));

        // keep i constant
        ans = Math.max(ans, findMaxProduct(nums1, nums2, m, n, i, j+1));

        dp[i][j] = ans;

        return ans;
    }
}