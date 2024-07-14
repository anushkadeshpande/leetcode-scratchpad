class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        // find sum of digits
        int sum = 0;
        int n = x;
        while(n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        if(x % sum == 0)
            return sum;
        else
            return -1;
    }
}