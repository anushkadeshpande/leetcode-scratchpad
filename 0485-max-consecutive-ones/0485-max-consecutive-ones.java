class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int ones = 0;
        
        for(int n: nums) {
            if(n == 1) {
                ones++;
            } else {
                maxOnes = Math.max(maxOnes, ones);
                ones = 0;
            }
            
        }
        maxOnes = Math.max(maxOnes, ones);
        return maxOnes;
    }
}