class Solution {
    public boolean isPalindrome(String s) {                
        int startPointer = 0;
        int endPointer = s.length() -1;
        
        while(startPointer < endPointer) {
            
            if(!isAlphaNumeric(s.charAt(startPointer))) 
                startPointer ++;
            else if(!isAlphaNumeric(s.charAt(endPointer)))
                endPointer--;
            else if(Character.toLowerCase(s.charAt(startPointer)) != Character.toLowerCase(s.charAt(endPointer)))
                return false;
            
            else {
                startPointer ++;
                endPointer --;
            }
        }
        
        return true;
    }
    
    private static boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
} 