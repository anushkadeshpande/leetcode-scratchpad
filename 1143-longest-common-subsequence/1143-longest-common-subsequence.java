class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        char[] text1Chars = text1.toCharArray();
        char[] text2Chars = text2.toCharArray();
        
        dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(text1Chars[i-1] == text2Chars[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        // return getLongestCommonSubsequence(text1, text2, n, m);
        return dp[n][m];
    }
}