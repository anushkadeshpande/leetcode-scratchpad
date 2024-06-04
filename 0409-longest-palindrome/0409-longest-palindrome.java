class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1)
            return 1;
        
        else {
            Map<Character, Integer> map = new HashMap<>();
            boolean oddFlag = false;
            
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                else 
                    map.put(c, 1);
            }
            int length = 0;
            for(Character c: map.keySet()) {
                if(map.get(c) % 2 == 0)
                    length += map.get(c);
                else {
                    length += map.get(c) - 1;
                    oddFlag = true;
                }
            }
            
            if(oddFlag)
                length += 1;
            
            return length;
        }
    }
}