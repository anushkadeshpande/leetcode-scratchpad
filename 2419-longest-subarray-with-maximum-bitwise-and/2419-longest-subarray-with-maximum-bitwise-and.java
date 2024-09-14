class Solution {
    public int longestSubarray(int[] nums) {
        // find largest number
        // find subarray with all large numbers
        
        int maxNum = nums[0];
        
        for(int num: nums) {
            maxNum = Math.max(num, maxNum);
        }
        
        int size = 0;
        int maxSize = 0;
        for(int num: nums) {
            if(num == maxNum) {
                size ++;
                maxSize = Math.max(size, maxSize);
            }
            else
                size = 0;
            
        }
        
        return maxSize;
    }
}