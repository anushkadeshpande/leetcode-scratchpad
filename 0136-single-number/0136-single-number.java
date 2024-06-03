class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            if(map.containsKey(num))
                map.put(num, 2);
            else {
                map.put(num, 1);
            }
        }
        
        
        for(Integer num: map.keySet()) {
            if(map.get(num) == 1)
                return num;
        }
        return 0;
    }
}