class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // take 10 chars, put in a hashset
        // keep moving the window
        // if it is present in the set, return it
        // else add to the set and keep checking
        
        int i = 0;
        int j = 10;
        int n = s.length();
        List<String> repeatedSequences = new ArrayList<>();
        Map<String, Integer> sequences = new HashMap<>();
        
        while(j <= n) {
            String seq = s.substring(i, j);
            if(sequences.containsKey(seq)) {
                // the sequence already exists
                int occ = sequences.get(seq);
                if(occ == 1)
                    repeatedSequences.add(seq);
                occ++;
                sequences.put(seq, occ);
            }
            else
                sequences.put(seq, 1);
            i++;
            j++;
        }
        
        return repeatedSequences;
    }
}