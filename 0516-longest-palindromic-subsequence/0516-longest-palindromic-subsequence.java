class Solution {
    int dp[][];
    
    public int longestPalindromeSubseq(String s) {
        // reverse string s
        int n = s.length();
        String s2 = reverse(s, n);
        // System.out.println(s2);
        dp = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
    
    public String reverse(String s, int n) {
        String s2 = "";
        for(int i=n - 1; i >= 0; i--)
            s2 = s2 + s.charAt(i);
        
        return s2;
    }
}