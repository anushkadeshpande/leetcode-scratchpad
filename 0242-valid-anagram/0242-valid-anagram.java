class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if(n != m)
            return false;
        
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        
        char[] s2 = t.toCharArray();
        Arrays.sort(s2);
        
        for(int i=0; i<n; i++) {
            if(s1[i] != s2[i])
                return false;
        }
        
        return true;
    }
}