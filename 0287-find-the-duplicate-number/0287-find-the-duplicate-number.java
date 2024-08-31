class Solution {
    public int findDuplicate(int[] nums) {
//         Set<Integer> set = new HashSet<>();
        
//         for(int n: nums) {
//             if(set.contains(n))
//                 return n;
//             else
//                 set.add(n);
//         }
         
//         return -1;
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if(nums[idx]< 0) {
                return idx;
            }
            
            // mark current number as visited
            nums[idx] = -nums[idx];
        }
        
        return -1;
    }
}