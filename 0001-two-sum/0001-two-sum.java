class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diff = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            int d = target - nums[i];
            
            if(diff.containsKey(d)) {
                ans[0] = i;
                ans[1] = diff.get(d);
            } else {
                diff.put(nums[i], i);
            }
        }
        
        return ans;
    }
}