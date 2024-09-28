class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for(int n : nums) {
            int sum = 0;
            while(n != 0) {
                sum += n % 10;
                n = n / 10;
            }
            
            minSum = Math.min(minSum, sum);
        }
        
        return minSum;
    }
}