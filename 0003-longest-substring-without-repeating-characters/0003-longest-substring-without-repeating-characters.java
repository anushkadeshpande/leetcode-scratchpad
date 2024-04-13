class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int l = 0;
        
        // Map<String, String> occurrenceMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        
        if(s.length() <= 1)
            return s.length();
        
        while(end < s.length()) {
            if(set.contains(s.charAt(end))) {
                // repeated char, increment start
                set.remove(s.charAt(start));
                start++;
            } else {
                // char is not repeated, include it
                // alse, add it to hashmap
                set.add(s.charAt(end));
                l = Math.max(l, end - start + 1);
                end++;
            }
        }
        
        return l;
    }
}