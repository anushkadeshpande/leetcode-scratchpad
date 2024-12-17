class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int currMaxSum = 0;
        int currMinSum = 0;
        
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        for(int n: nums) {
            sum += n;
            currMaxSum += n;
            currMinSum += n;
            maxSum = Math.max(maxSum, currMaxSum);
            minSum = Math.min(minSum, currMinSum);
            
            if(currMinSum > 0) {
                // do not carry the sum
                currMinSum = 0;
            }
            
            if(currMaxSum < 0) {
                // do not carry the sum
                currMaxSum = 0;
            }
            
        }
        
        // if all the elements are negative, minSum will be equal to the sum of the array
        // so return maxSum
        if(minSum == sum)
            return maxSum;
        
        // else return the maxSum(without the cycle) or return the circular sum
        return Math.max(maxSum, sum-minSum);
    }
}