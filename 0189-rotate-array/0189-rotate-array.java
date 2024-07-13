class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        // normalize k
        k = k % n;
        
        // get last k elements
        int[] lastKElements = new int[k];
        int j = 0;
        for(int i= n -k; i < n; i++) {
            lastKElements[j++] = nums[i];
        }
        
        // shift array by k places
        for(int i = n - 1; i >= k ; i--) {
            nums[i] = nums[i-k];
        }
        
        // add those k elements at the beginning
        for(int i=0; i<k ;i++) {
            nums[i] = lastKElements[i];
        }
    }
}