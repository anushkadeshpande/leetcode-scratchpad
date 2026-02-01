class Solution {
    public int minimumCost(int[] nums) {
        int i = 0;
        int cost = nums[0];
        // we need to find the next 2 smallest elements   
        // sort the remaining array
        nums[0] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        cost += nums[0];
        cost += nums[1];

        return cost;
    }
}