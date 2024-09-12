class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars = new HashSet<>();
        
        for(int i=0; i<allowed.length(); i++) 
            allowedChars.add(allowed.charAt(i));
        
        int count = 0;
        for(String word: words) {
            int j = 0;
            for(j =0; j<word.length(); j++) {
                if(!allowedChars.contains(word.charAt(j)))
                    break;
            }
            
            if(j == word.length())
                count++;
        }
        
        return count;
    }
}