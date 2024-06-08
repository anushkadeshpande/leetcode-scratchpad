class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        // using prefix sum method
        
        // map of remainders and indexes
        Map<Integer, Integer> map = new HashMap<>();
        
        // if the 1st element matches
        map.put(0, -1);
        
        int sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            
            Integer idx = map.get(rem);
            
            if(null == idx)
                map.put(rem, i);
            else if(i - idx > 1)
                return true;
        }
        
        return false;
    }
}