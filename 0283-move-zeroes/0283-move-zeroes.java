class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int n = nums.length;
        int i =0;
        
        for(i=0; i<n; i++) {
            if(nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        
        for(i=idx; i<n; i++)
            nums[i] = 0;
    }
}