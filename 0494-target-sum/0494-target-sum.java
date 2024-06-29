class Solution {
    
    public int countSubarraySum(int[] nums, int n, int target) {
        if(target == 0 && n == 0)
            return 1;
        
        if(n <= 0)
            return 0;
        
        if(nums[n-1] <= target)
            return countSubarraySum(nums, n-1, target-nums[n-1]) + countSubarraySum(nums, n-1, target);
        else
            return countSubarraySum(nums, n-1, target);
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        // we need to divide nums into 2 subarrays n1 and n2
        // n2 has all elements we chose to put `-` before
        // hence, effectively n1 - n2 = target
        // hence, same as subset sum difference problem
        
        // 1. find sum of array --> will give n1 + n2 = s
        // 2. n1 + n2 = s, n1 - n2 = target, hence, n1 = s + target / 2
        
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++)
            sum += nums[i];
                
        if((sum + target) % 2 != 0)
            return 0;
        
        int tgtSum = (sum + target) / 2;
        
        if(tgtSum < target)
            return 0;

        return countSubarraySum(nums, n, tgtSum);
    }
}