class Solution {
    public long countCompleteDayPairs(int[] hours) {
        // two sum problem
        Map<Integer, Long> map = new HashMap<>();
        
        long count = 0;
        
        for(int hr: hours) {
            
            // get remainder for every hr
            // if that remainder exists in the array, increment the count
            int rem = hr % 24;
            
            int x = (24 - rem) % 24;
            // if remainder exists in map, that many possibilities
            if(map.containsKey(x)) {
                count += map.get(x);
                // map.put(hr%24, count + 1);
            } 
            // else {
            //     map.put(hr%24, 1);
            // }
            
            map.put(rem, map.getOrDefault(rem, 0l) + 1);
        }
        
        return count;

    }
}