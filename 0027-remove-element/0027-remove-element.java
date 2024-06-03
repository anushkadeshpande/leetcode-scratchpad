class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int counter = 0;
            
        while(left <= right) {
            if(nums[right] == val) {
                right--;
                counter ++;
            }
            else if(nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                left ++;
                right --;
                counter++;
            } else 
                left++;
        }
        
        return nums.length - counter;
    }
}