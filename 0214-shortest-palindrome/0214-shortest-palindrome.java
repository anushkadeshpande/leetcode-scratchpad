class Solution {
    public String shortestPalindrome(String s) {
        String revStr = reverse(s);
        
        for(int i=0; i<s.length(); i++) {
            
            if(s.substring(0, s.length()-i).equals(revStr.substring(i))) {
               return revStr.substring(0,i) + s; 
            }
        }
        
        return "";
    }
    
    public String reverse(String s) {
        String rev = "";
        for(int i=s.length()-1; i>=0; i--) {
            rev = rev + s.charAt(i);
        }
        
        return rev;
    }
}