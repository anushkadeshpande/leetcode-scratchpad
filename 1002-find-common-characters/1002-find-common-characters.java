class Solution {
    public List<String> commonChars(String[] words) {
        int[] charFrequency = new int[26];
        
        // initialize with frequency of chars of str1
        for(int i=0; i<words[0].length(); i++) {
            charFrequency[words[0].charAt(i) - 'a']++;
        }
        
        for(String word: words) {
            int[] freq = new int[26];
            for(int i=0; i<word.length(); i++)
                freq[word.charAt(i) - 'a'] += 1;
            
            for(int i=0; i<26; i++)
                charFrequency[i] = Math.min(charFrequency[i], freq[i]);
        }
        
        List<String> result = new ArrayList<>();
        for(int i=0; i<26; i++) {
            for(int j=0; j<charFrequency[i]; j++)
                result.add(Character.toString(i + 'a'));
        }
        
        
        return result;
    }
}