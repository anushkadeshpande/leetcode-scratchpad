class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet(Arrays.stream(nums).boxed().toList());
        
        if(numsSet.size() == nums.length)
            return false;
        return true;
    }
}