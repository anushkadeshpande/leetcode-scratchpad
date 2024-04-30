class Solution {
    public long wonderfulSubstrings(String word) {
        // two pointers
        // track the occurrence of chars in the string
        // increment right pointer till the string is valid
        // once string turns invalid, increment the left pointer till it turns valid again
//         int left = 0; 
//         int right = 0;
        
//         int count = 0;
        
//         Map<Character, Integer> occurrenceMap = new HashMap<>();
        
//         occurrenceMap.put(word.charAt(0), 1);
//         count ++;
        
//         while(right != word.length() - 1 && left != word.length() - 1) {
//             right++;
//             if(occurrenceMap.containsKey(word.charAt(right))) {
//                 // increment the count
//                 occurrenceMap.put(word.charAt(right), occurrenceMap.get(word.charAt(right)));
                
//                 // check if valid
//                 if(occurrenceMap.get(word.charAt(right)) % 2 != 0) {
//                     // string is valid
//                 } 
//             }
//         }
        
//         return count;
        
        
        long res = 0;
        int n = word.length();
        long[] count = new long[1024];
        count[0] = 1;
        int cur = 0;
        
        for (int i = 0; i < n; i++) {
            cur ^= 1 << (word.charAt(i) - 'a');
            res += count[cur];
            
            for (int j = 0; j < 10; j++) {
                res += count[cur ^ (1 << j)];
            }
            
            count[cur]++;
        }
        
        return res;
    
    }
}