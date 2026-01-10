class Solution {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        // longest common subsequence
        // track the deleted chars
        // add up their ascii
        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        int commonAscii = getLongestCommonSubsequence(s1, s2, m, n, 0, 0);
        // get ascii for the string
        int totalAscii = 0;
        for(int i=0; i<m; i++)
            totalAscii += s1.charAt(i);
        for(int i=0; i<n; i++)
            totalAscii += s2.charAt(i);

        return totalAscii - (2 * commonAscii);
    }

    public int getLongestCommonSubsequence(String s1, String s2, int m, int n, int i, int j) {
        if(i == m || j == n)
            return 0;

        if(dp[i][j]!= 0)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            // take the char
            dp[i][j] = s1.charAt(i) + getLongestCommonSubsequence(s1, s2, m, n, i+1, j+1);
        }
        else {
            int takeI = getLongestCommonSubsequence(s1, s2, m, n, i+1, j);
            int takeJ = getLongestCommonSubsequence(s1, s2, m, n, i, j+1);

            if(takeI > takeJ) {
                dp[i][j] = takeI;
            } else {
                dp[i][j] = takeJ;
            }
        }

        return dp[i][j];        
    }
}