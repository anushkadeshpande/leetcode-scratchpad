class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // fast pointer slow pointer
        // slow pointer moves by 1, fast moves by 2
        int n = nums.length;
        boolean negative = true;
        Set<Integer> visited;
        int cycleLength = 1;
        
        for(int i=0; i<n; i++) {
            visited = new HashSet<>();
            
            int slow = i;
            int fast = 0;
            
            if(nums[i] < 0)
                fast = (slow + nums[slow] + n) % n;
            else
                fast = (slow + nums[slow]) % n;
            
            if (fast < 0) {
                    fast += n;
                }
            
            // variable to set the type of check
            negative = nums[i] < 0 ? true : false;
            
            cycleLength = 1;
            
            while(slow != fast) {
                
                // System.out.println(slow + "-" +visited.contains(slow));
                
                if(visited.contains(slow)) 
                   if(cycleLength > 1) {
                       // System.out.println(slow);
                       // System.out.println(fast);
                        return true;
                   }
                   else
                        break;
                
                // check if the visited array is valid
                if(negative) {
                    if(nums[slow] >= 0)
                        break;
                    // if(nums[fast] >= 0)
                    //     break;
                } else {
                    if(nums[slow] <= 0)
                        break;
                }
                               
                visited.add(slow);
                // visited.add(fast);
                
                cycleLength++;
                
                // if(nums[slow] < 0) {
                //     slow = (slow + nums[slow] + n) % n;
                // } else 
                //     slow = (slow + nums[slow]) % n;
                
                slow = fast;
            
                if(nums[fast] < 0)
                    fast = (fast + nums[fast] + n) % n;
                else
                    fast = (fast + nums[fast]) % n;
                
                if (fast < 0) {
                    System.out.println(fast);
                    fast += n;
                }
                
            }
            
        }
        
        return false;
        
    }
}