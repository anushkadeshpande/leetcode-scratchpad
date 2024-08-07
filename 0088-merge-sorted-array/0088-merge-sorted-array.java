class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 and nums2 are already sorted
        int nums1End = m-1;
        int nums2End = n-1;
        int i = m + n - 1;
        
        while(nums2End >= 0) {
            if(nums1End < 0 || nums1[nums1End] < nums2[nums2End]) {
                // copy numbers from nums2
                nums1[i] = nums2[nums2End];
                i--;
                nums2End--;
            } else {
                nums1[i] = nums1[nums1End];
                i--;
                nums1End--;
            }
        }
    }
}