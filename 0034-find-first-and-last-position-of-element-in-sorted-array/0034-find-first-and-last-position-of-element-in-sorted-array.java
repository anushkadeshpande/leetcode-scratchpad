class Solution {
    public int[] searchRange(int[] nums, int target) {
        // binary search
        int n = nums.length;
        int start = 0;
        int end = n-1;

        int firstPos = -1;
        int lastPos = -1;
        

        // look for 1st occurence
        while(start <= end) {
            int mid = (start + end)/2;

            if(nums[mid] == target) {
                firstPos = mid;
                lastPos = mid;

                while(firstPos>=0 && nums[firstPos] == target)
                    firstPos--;
                firstPos++;

                while(lastPos < n && nums[lastPos] == target)
                    lastPos++;
                lastPos--;
                break;
            } else if(nums[mid] < target) { 
                start = mid + 1;
            } else {
                end = mid - 1;                
            }
        }

        return new int[]{firstPos, lastPos};
    }
}