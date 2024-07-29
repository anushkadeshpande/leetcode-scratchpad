class Solution {
    public boolean isPrime(int n) {
        if(n % 2 == 0)
            return false;
        
        for(int i=3; i<=Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        
        return true;
    }           
    
    public boolean isPalindrome(int n) {
        int temp = n;
        int rev = 0;
        while(temp != 0) {
            rev = (rev*10) + temp % 10;
            temp = temp / 10;
        }
        
        if(rev == n)
            return true;
        return false;
    }
    
    public int primePalindrome(int n) {
        if(n <= 2) return 2;
        if(n <= 3) return 3;
        if(n <= 5) return 5;
        if(n <= 7) return 7;
        if(n <= 11) return 11;
        if(n <= 100) return 101;
        if(n >= 9989900) return 100030001;
        
        while(true) {
           if(isPalindrome(n) && isPrime(n)) 
             return n;
            n++;
        }
    }
}