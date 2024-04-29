class Solution {
    public int minOperations(int[] nums, int k) {
        // XOR -- one 1 -- 1
        
        int finalXOR = 0;
        for(int i=0; i<nums.length; i++){
            finalXOR = finalXOR^nums[i];
        }
        int count =0;
        while(k>0 || finalXOR>0){
            if(k%2 != finalXOR%2){
                count++;
            }
            k=k/2;
            finalXOR=finalXOR/2;

        }
        return count;
    }
}