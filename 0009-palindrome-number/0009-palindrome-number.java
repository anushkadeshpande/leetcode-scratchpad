class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int revNum = 0;
        
        // reverse the number
        if(num < 0)
            return false;
        while(num != 0) {
            revNum = (revNum *10) + (num % 10) ;
            num = num / 10;
        }
        
        
        // check if the two numbers are equal
        if(x == revNum)
            return true;
        return false;
    }
}