class Solution {
    public void nextPermutation(int[] nums) {
        // find the breakpoint i.e where ith element < i+1th element
        int breakpoint = -1;
        int n = nums.length;
        
        if(n != 1) {
        
            for(int i=n-2; i>=0; i--) {
                if(nums[i] < nums[i+1]) {
                    breakpoint = i;
                    break;
                }
            }
        
            // if breakpoint is 0, sort the array
            if(breakpoint == -1) {
                Arrays.sort(nums);
            } else {
                // from i+1 to the end of the array, find the number which is just greater than the ith number
                int justGreaterElement = breakpoint+1;
                for(int i=breakpoint+1; i<n; i++) {
                    if(nums[i] < nums[justGreaterElement] && nums[i] > nums[breakpoint])
                        justGreaterElement = i;
                }
        
                // swap breakpoint with just greater element
                int temp = nums[breakpoint];
                nums[breakpoint] = nums[justGreaterElement];
                nums[justGreaterElement] = temp;
            
                // sort the remaining numbers
                int[] subarray = Arrays.copyOfRange(nums, breakpoint+1, n);
                Arrays.sort(subarray);
            
                int j = 0;
                for(int i=breakpoint+1; i<n; i++)
                    nums[i] = subarray[j++];
            }
        }
    }
}