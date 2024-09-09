class Solution {
    public boolean checkMatch(String s, String p, int sIndex, int pIndex) {
        // if char match go ahead
        // if dot, skip one char
        // if *, either use it or ignore it
        
        // we've reached the end of both s and p, so everything has matched
        if(sIndex >= s.length() && pIndex >= p.length())
            return true;
        
        // we've exhausted the pattern, but are still left with the string, hence, invalid
        if(pIndex >= p.length())
            return false;
        
        
        boolean match = false;
        // if characters match, it could be a match
        // we can also have a *, in that case we need to further check it
        // hence, we cannot directly return true here
        if(sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex))
            match = true;
        
        // if it is a '.', whatever is the char, it could match, but need further checking if the next char is '*'
        else if(sIndex < s.length() && p.charAt(pIndex) == '.')
            match = true;
        
        // if next char is char, we consider it or skip it
        // if we consider it, the current match should also be true
        if(pIndex+1 < p.length() && p.charAt(pIndex+1) == '*')
            return (match && checkMatch(s, p, sIndex+1, pIndex)) || checkMatch(s, p, sIndex, pIndex+2);
        
        // if the next char is not * and we've already matched the chars, check the next chars in s and p
        if(match == true)
            return checkMatch(s, p, sIndex+1, pIndex+1);
        
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        return checkMatch(s, p, 0, 0);
    }
}