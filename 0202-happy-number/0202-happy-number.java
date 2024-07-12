class Solution {
    public int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            int num = n%10; 
            sum += num * num;
            
            n = n / 10;
        }
        
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
       do {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while(fast != slow);
        
        return slow == 1;
    }
}