class Solution {
    public int missingNumber(int[] nums) {
        int targetSum = 0;
        int sum = 0;
        // find sum of numbers from 1 - nums.length
        for(int i=1; i<=nums.length; i++)
            targetSum += i;
        
        // find sum of array
        for(int i=0; i<nums.length; i++)
            sum += nums[i];
        
        // diff is the missing number
        return targetSum - sum;
    }
}