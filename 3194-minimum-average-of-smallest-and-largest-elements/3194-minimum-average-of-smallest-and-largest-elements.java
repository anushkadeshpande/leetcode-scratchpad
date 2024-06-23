class Solution {
    public double minimumAverage(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        
        int i=0;
        int n = nums.length;
        double minAvg = Double.MAX_VALUE;
        
        while(i != n / 2) {
            // find avg of min and max element
            minAvg = Math.min((nums[i] + nums[n-i-1])/2.0 , minAvg);
            i++;
        }
        
        return minAvg;
    }
}