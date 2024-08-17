class Solution {
    public boolean isSubsequence(String s, String t) {
        // find lcs of both strings
        // if lcs == s ? true : false
//         int n = s.length();
//         int m = t.length();
        
//         int[][] dp = new int[n+1][m+1];
        
//         for(int i=0; i<=n; i++) {
//             for(int j=0; j<=m; j++) {
//                 if(i == 0 || j == 0)
//                     dp[i][j] = 0;
//                 else if(s.charAt(i-1) == t.charAt(j-1)) {
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 } else
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//             }
//         }
        
//         return dp[n][m] == n ? true : false;
        
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = t.length();
        
        while(i < n && j < m) {
            if(s.charAt(i) == t.charAt(j)) 
                i++;
               
            j++;                
        }
        
        return i == n? true : false;
    }
}