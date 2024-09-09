class Solution {
    public int rob(int[] nums) {
        // for every house we either rob it or not
        
        // we cannot rob both the 1st and the last houses at once
        // max rob without 1st and the last houses
        int n = nums.length;
        
        if(n == 0)
            return 0;
        else if(n == 1)
            return nums[0];
        
        return Math.max(getMaxRob(Arrays.copyOfRange(nums, 1, nums.length)), getMaxRob(Arrays.copyOfRange(nums, 0, nums.length-1)));
    }
    
    public int getMaxRob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        // calculating with 1st house
        for(int i=1; i<nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        
        return dp[n];
    }
}