class Solution {
    public int findRotateSteps(String ring, String key) {
        // can treat ring as graph? and find shortest path to the next char in the key?
        
        // keep a track of the ring and the key
        return calculateRotateSteps(ring, key, 0, 0);
    }
    
    Map<String, Integer> memo = new HashMap<>();
    
    public int calculateRotateSteps(String ring, String key, int ringPos, int keyPos) {
        // base case
        if(keyPos == key.length())
            return 0;
        
        String memoKey = ringPos + ":" + keyPos;
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int result = Integer.MAX_VALUE;
        int dist = 0;
        // iterate over ring
        // find minimum distance between character and the keyChar   --> number of steps to get to the character
        for(int i=0; i<ring.length(); i++) {
            if(ring.charAt(i) == key.charAt(keyPos)) {
                // we can reach the char either clockwise or anticlockwise, and need to take minimum of the distances
                dist = Math.min(Math.abs(ringPos - i), ring.length() - Math.abs(ringPos - i));
                
                result = Math.min(result, dist + 1 + calculateRotateSteps(ring, key, i, keyPos+1));
            }
        }
        
        memo.put(memoKey, result);
        return result;
    }
}