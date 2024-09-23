class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bannedWordsSet = new HashSet<>();
        
        for(String word: bannedWords) {
            bannedWordsSet.add(word);   
        }
        
        int count = 0;
        for(String word: message) {
            if(bannedWordsSet.contains(word))
                count++;
            if(count >= 2)
                return true;
        }
        
        return false;
    }
}