class Solution {
    public boolean judgeSquareSum(int c) {
        // take closest sq root of c
        // c - sq(closest_sq_root) = b^2
        // if b is a perfect square, return true else false
        int a = (int)Math.floor(Math.sqrt(c));
        
        // for every a from a to 0, check if we can get a b
        if(a*a == c)
            return true;
        for(int i=a; i>= 0; i--) {
            int bSquare = c - ( i * i );
        
            double b = Math.sqrt(bSquare);
            
            if(Math.floor(b) == b)
                return true;
            
        }

        return false;
    }
}