class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        boolean flag = false;

        for(int i=0; i<n; i++) {
            flag = false;

            if(i - k >= 0) {
                if(nums[i] > nums[i-k])
                    flag = true;
            } else
                flag = true;

            if(i + k < n) {
                if(nums[i] > nums[i + k] && flag)
                    sum += nums[i];
            } else {
                if(flag)
                    sum += nums[i];
            }

            // if((i - k >= 0 && nums[i] > nums[i-k]) || (i + k < n && nums[i] > nums[i + k])) 
            //     sum += nums[i];
        }

        return sum;
    }
}