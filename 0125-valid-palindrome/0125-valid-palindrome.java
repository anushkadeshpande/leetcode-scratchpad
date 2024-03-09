class Solution {
    public boolean isPalindrome(String s) {
        
        // clean the string
        // remove non alphanumeric characters
        
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        
        // convert all to lowercase
        s = s.toLowerCase();
                
        int startPointer = 0;
        int endPointer = s.length() -1;
        
        while(startPointer < endPointer) {
            if(s.charAt(startPointer) != s.charAt(endPointer)) 
                return false;
            
            startPointer ++;
            endPointer --;
        }
        
        return true;
    }
}