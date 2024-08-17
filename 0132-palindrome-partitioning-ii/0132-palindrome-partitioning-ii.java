class Solution {
    
    public int[][] dp;
    
    public int[][] palindromeDp;
    
    public String s1;
    
    public int getMinCuts(int i, int j) {
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(i >= j || isPalindrome(i, j))
            return 0;
        
        int minCuts = Integer.MAX_VALUE;
        
        for(int k=i; k<j; k++) {
            if(isPalindrome(i, k)) {
                int cuts = 1 + getMinCuts(k+1, j);
                minCuts = Math.min(minCuts, cuts);    
            }
            
        }
        
        dp[i][j] = minCuts;
        
        return minCuts;
    }
    
    public int minCut(String s) {
        int n = s.length();
        
        dp = new int[n+1][n+1];
        palindromeDp = new int[n+1][n+1];
        
        s1 = s;
        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++) {
                    dp[i][j] = -1;
                    palindromeDp[i][j] = -1;
            }
        
        return getMinCuts(0, s.length()-1);
    }
    
    public boolean isPalindrome(int i, int j) {
        if(palindromeDp[i][j] != -1)
            return palindromeDp[i][j] == 1;
        
        int p = i;
        int q = j;
        
        while(p < q) {
            if(s1.charAt(p) != s1.charAt(q)) {
                palindromeDp[i][j] = 0;
                
                return false;
            }
            
            p++;
            q--;
        }
        
        palindromeDp[i][j] = 1;
        
        return true;
    }
}