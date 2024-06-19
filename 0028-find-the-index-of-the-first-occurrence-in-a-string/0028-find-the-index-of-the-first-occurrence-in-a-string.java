class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while(i < haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(j))
                j++;
            else {
                i -= j;
                j = 0;
            }
            
            i++;

            if(j == needle.length())
                return i - needle.length();
        }
        
        return -1;
    }
}