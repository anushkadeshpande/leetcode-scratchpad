class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        
        // find before product
        product[0] = 1;
        for(int i=1; i<n; i++) {
            product[i] = product[i-1] * nums[i-1];
        }

        // find after product
        // multiply them
        int p = 1;
        for(int i=n-2; i>=0; i--) {
            p = p * nums[i+1];
            product[i] = product[i] * p;          
        }
        
        return product;
    }
}