class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        for(String word: s1.split(" ")) {
            count = 0;
            if(map.containsKey(word))
                count = map.get(word);
            count++;
            map.put(word, count);
        }
        
        for(String word: s2.split(" ")) {
            count = 0;
            if(map.containsKey(word))
                count = map.get(word);
            count++;
            map.put(word, count);
        }
        
        List<String> resultList = new ArrayList<>();
        
        for(String word: map.keySet()) {
            if(map.get(word) == 1)
                resultList.add(word);
        }
        
        String[] result = new String[resultList.size()];
        
        return resultList.toArray(result);
    }
}