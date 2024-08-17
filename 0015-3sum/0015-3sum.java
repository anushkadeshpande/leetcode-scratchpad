class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        int left = 0;
        int right = 0;
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            left = i+1;
            right = n-1;
            
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            while(left < right) {
                if(nums[left] + nums[right] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && right < n-1 && nums[right] == nums[right + 1]) right--;
                } else if(nums[left] + nums[right] + nums[i] > 0)
                    right--;
                else
                    left ++;
                
                
                    
            }
        }
        
        return res;
    }
}