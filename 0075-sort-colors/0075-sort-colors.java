class Solution {
    public void sortColors(int[] nums) {
        int zeroPtr = 0;
        int twoPtr = nums.length - 1;
        int idx = 0;
        
        while(idx <= twoPtr) {
            if(nums[idx] == 2) {
                nums[idx] = nums[twoPtr];
                nums[twoPtr] = 2;
                twoPtr--;
            } else if(nums[idx] == 0) {
                nums[idx] = nums[zeroPtr];
                nums[zeroPtr] = 0;
                zeroPtr++;
                idx++;
            } else 
                idx++;
            
        }
    }
}