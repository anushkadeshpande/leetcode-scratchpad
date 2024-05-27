class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums) {
            if(map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }
        
        int maxKey = -1;
        for(int key : map.keySet()) {
            if(maxKey == -1)
                maxKey = key;
            else
                maxKey = map.get(maxKey) > map.get(key)? maxKey : key;
        }
                         
        return maxKey;
    }
}