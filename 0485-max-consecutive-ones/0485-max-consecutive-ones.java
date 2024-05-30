class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int ones = 0;
        
        for(int n: nums) {
            if(n == 1) {
                ones++;
                maxOnes = Math.max(maxOnes, ones);
            } else {
                ones = 0;
            }
            
        }
        
        return maxOnes;
    }
}