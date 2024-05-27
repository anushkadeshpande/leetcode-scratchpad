class Solution {
    public void rotate(int[] nums, int k) {
        
        // normalize k
        k = k % nums.length;
        
        // get last k elements
        int[] lastKElements = new int[k];
        int j = 0;
        for(int i= nums.length -k; i < nums.length; i++) {
            lastKElements[j++] = nums[i];
        }
        
        // shift array by k places
        for(int i = nums.length - 1; i >= k ; i--) {
            nums[i] = nums[i-k];
        }
        
        // add those k elements at the beginning
        for(int i=0; i<k ;i++) {
            nums[i] = lastKElements[i];
        }
    }
}