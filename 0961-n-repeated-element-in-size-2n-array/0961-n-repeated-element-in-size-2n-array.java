class Solution {
    public int repeatedNTimes(int[] nums) {
        // figure out what is n
        // sort arr
        // check which number appears n times

        int n = nums.length/2;
        Arrays.sort(nums);

        int cnt=1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                cnt++;
                if(cnt == n)
                    return nums[i];
            }
            else
                cnt = 1;
        }

        return 0;
    }
}