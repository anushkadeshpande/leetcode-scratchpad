class Solution {
    int[][] dp;
//     public int getLongestCommonSubsequence(String str1, String str2, int n, int m) {
//         if(n == 0 || m == 0)
//             return 0;
        
//         if(dp[n][m] != -1)
//             return dp[n][m];
        
//         if(str1.charAt(n-1) == str2.charAt(m-1))
//             dp[n][m] = 1 + getLongestCommonSubsequence(str1, str2, n-1, m-1);
//         else
//             dp[n][m] = Math.max(getLongestCommonSubsequence(str1, str2, n-1, m), getLongestCommonSubsequence(str1, str2, n, m-1));
        
//         return dp[n][m];
//     }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        // return getLongestCommonSubsequence(text1, text2, n, m);
        return dp[n][m];
    }
}