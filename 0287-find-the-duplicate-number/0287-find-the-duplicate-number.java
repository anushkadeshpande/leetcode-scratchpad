class Solution {
    public int findDuplicate(int[] nums) {

        // METHOD 1
//         Set<Integer> set = new HashSet<>();
        
//         for(int n: nums) {
//             if(set.contains(n))
//                 return n;
//             else
//                 set.add(n);
//         }
         
//         return -1;

        
        // METHOD 2
//         for(int i=0; i<nums.length; i++) {
//             int idx = Math.abs(nums[i]);
//             if(nums[idx]< 0) {
//                 return idx;
//             }
            
//             // mark current number as visited
//             nums[idx] = -nums[idx];
//         }
        
        
        
        // METHOD 3
        // linked list cycle method
        int slow = nums[0];
        int fast = nums[0];
        
        // while(slow != fast) {
        //     slow = nums[slow];
        //     fast = nums[nums[fast]];
        // }
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        fast = nums[0];
        
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}