class Solution {
    public int appendCharacters(String s, String t) {
        int idx = 0;
        int sLength = s.length();
        int tLength = t.length();
        
        for(int i=0; i<sLength && idx < tLength; i++) {
            if(s.charAt(i) == t.charAt(idx))
                idx++;
        }
        
        return tLength - idx;
    }
}