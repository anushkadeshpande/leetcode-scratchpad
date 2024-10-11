class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int n = nums.length;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        
        for(int i=idx; i<n; i++)
            nums[i] = 0;
    }
}