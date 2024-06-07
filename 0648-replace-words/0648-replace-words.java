class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        
        Map<String, String> wordMap = new HashMap();
        
       
        for(int i=0; i<words.length; i++) {
             for(String dictWord: dictionary) {
                if(words[i].startsWith(dictWord)) {
                    if(wordMap.containsKey(words[i])) {
                        if(wordMap.get(words[i]).length() > dictWord.length())
                            wordMap.put(words[i], dictWord);        
                    } else
                        wordMap.put(words[i], dictWord);
                }
                
            }
            if(wordMap.containsKey(words[i]))
                words[i] = wordMap.get(words[i]);
        }
        
        return String.join(" ", words);
    }
}