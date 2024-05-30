class Solution {
    public int missingNumber(int[] nums) {
        int targetSum = 0;
        int sum = 0;
        // find sum of numbers from 1 - nums.length
        // sum = n * (n + 1)/2
        targetSum = nums.length * (nums.length + 1) / 2;
        
        // find sum of array
        for(int i=0; i<nums.length; i++)
            sum += nums[i];
        
        // diff is the missing number
        return targetSum - sum;
    }
}