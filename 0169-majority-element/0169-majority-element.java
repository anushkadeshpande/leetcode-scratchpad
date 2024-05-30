class Solution {
    public int majorityElement(int[] nums) {
        
        // using moore's voting algo
        int count = 0;
        int maxEle = -1;
        for(int n: nums) {
            if(count == 0) {
                maxEle = n;
                count ++;
            } else if(n == maxEle) {
                count++;
            } else
                count --;
        }
        
        // verify if maxEle is actually the majority element --- is this required??
        
        return maxEle;
    }
}