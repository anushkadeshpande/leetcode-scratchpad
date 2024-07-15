class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        
        for(int i=0; i<jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        
        int cnt = 0;
        
        for(int i=0; i<stones.length(); i++) {
            char currentChar = stones.charAt(i);
            if(set.contains(currentChar))
                cnt++;
        }
        
        return cnt;
    }
}