class Solution {
    Map<String, Boolean> map = new HashMap<>();
    
    public boolean canPartitionArray(int[] arr, int n, int target) {
        if(target == 0)
            return true;
        
        if(n <= 0)
            return false;
        
        // if(dp[n][target] != -1)
        //     return dp[n][target] == 1;
        
        String key = n + ":" + target;
        
        if(map.containsKey(key))
            return map.get(key);
        
        // if(target >= arr[n-1])
        //     dp[n][target] = (canPartitionArray(arr, n-1, target-arr[n-1]) || canPartitionArray(arr, n-1, target))? 1 : 0;
        // else
        //     dp[n][target] = canPartitionArray(arr, n-1, target) ? 1 : 0;
        
        if(target >= arr[n-1])
            map.put(key, (canPartitionArray(arr, n-1, target-arr[n-1]) || canPartitionArray(arr, n-1, target)));
        else
            map.put(key, canPartitionArray(arr, n-1, target));

        return map.get(key);
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) 
            sum += nums[i];
        if(sum % 2 != 0)
          return false;
        
//         dp = new int[nums.length+1][(sum/2) + 1];
        
//         for(int i=0; i<=nums.length; i++)
//             for(int j=0; j<=sum/2; j++)
//                 dp[i][j] = -1;
        
        return canPartitionArray(nums, nums.length, sum/2);
    }
}