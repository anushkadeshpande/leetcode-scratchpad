class Solution {
    
    public boolean isValidPalindrome(String s, int i, int j, boolean charSkippedFlg) {
        if(i >= j)
            return true;
        if(s.charAt(i) == s.charAt(j))
            return isValidPalindrome(s, i+1, j-1, charSkippedFlg);
        else if(!charSkippedFlg && s.charAt(i) != s.charAt(j))
            return isValidPalindrome(s, i+1, j, true) || isValidPalindrome(s, i, j-1, true);
        else
            return false;
            
    }
    
    public boolean validPalindrome(String s) {
        return isValidPalindrome(s, 0, s.length() - 1, false);
    }
}