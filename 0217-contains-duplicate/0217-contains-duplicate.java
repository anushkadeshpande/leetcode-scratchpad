class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet();
        
        for(int num: nums) {
            numsSet.add(num);
        }
        
        if(numsSet.size() == nums.length)
            return false;
        return true;
    }
}