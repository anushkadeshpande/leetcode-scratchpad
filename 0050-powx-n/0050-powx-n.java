class Solution {
    public double myPow(double x, int n) {
        
        if(x == 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        if(n == 1)
            return x;
        
        double res = myPow(x, Math.abs(n/2));
        
        res = res * res;
        
        if(n % 2 != 0)
            res = x * res;
        
        return n>=0 ? res : 1/res;
    }
}