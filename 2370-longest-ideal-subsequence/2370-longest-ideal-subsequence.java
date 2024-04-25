class Solution {
    int[][] memo = null;
    
    private int solveMemo(String s, int idx, int k, char ch) {
        // Base Case
        if (idx >= s.length()) {
            return 0;
        }

        // check if value memoized
        if (memo[idx][ch] != -1) {
            return memo[idx][ch];
        }

        int includeChar = 0;
        int excludeChar = 0;
        
        // include character
        if (Math.abs(ch - s.charAt(idx)) <= k || ch == '#') {
            includeChar = 1 + solveMemo(s, idx + 1, k, s.charAt(idx));
        }
        
        // exclude character
        excludeChar = solveMemo(s, idx + 1, k, ch);

        return memo[idx][ch] = Math.max(includeChar, excludeChar);
    }
    
    public int longestIdealString(String s, int k) {
        // for every character, we either choose it or not
        memo = new int[s.length() + 1][130];
        for (int[] d : memo) {
            Arrays.fill(d, -1);
        }
        return solveMemo(s, 0, k, '#');
    }
}
