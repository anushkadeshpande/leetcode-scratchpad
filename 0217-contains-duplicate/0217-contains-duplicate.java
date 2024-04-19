class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        
        for(Integer n: nums) {
            if(occurrenceMap.containsKey(n)) {
                return true;
            } else 
                occurrenceMap.put(n ,1);
        }
        
        return false;
    }
}