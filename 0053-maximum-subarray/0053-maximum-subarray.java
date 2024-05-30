class Solution {
    public int maxSubArray(int[] nums) {
        // using kadanes algorithm
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int n: nums) {
            sum += n;

            maxSum = Math.max(maxSum, sum);
            
            if(sum < 0) {
                // do not carry the sum
                sum = 0;
            }
            
        }
        
        return maxSum;
    }
}