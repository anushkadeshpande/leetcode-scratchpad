class Solution {
    public boolean isPalindrome(String s) {                
        // 1. sanitize the string
        // 1.1 convert all to lowercase
        // 1.2 remove all non-alphanumeric characters
        // 1.3 remove all spaces
        
        // 2. need to check if it is a palindrome
        
        String sanitizedString = "";
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != ' ' && isAlphaNumeric(s.charAt(i)))
                sanitizedString += Character.toLowerCase(s.charAt(i));
        }
                
        int i = 0;
        int j = sanitizedString.length() - 1;
        
        while(i < j) {
            if(sanitizedString.charAt(i) != sanitizedString.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        return ((c >= 'a' && c <= 'z') 
                || (c >= 'A' && c <= 'Z') 
                || (c >= '0' && c <= '9'));
    }
    
} 