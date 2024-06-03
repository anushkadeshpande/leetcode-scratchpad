class Solution {
    public int findDuplicate(int[] nums) {
        int xor = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            xor = nums[i] ^ nums[i-1];
            if(xor == 0)
                return nums[i];
        }
        
        return -1;
    }
}