class Solution {
    class Trie {
        Node root;    
        
        public Trie() {
            root = new Node();
        }
        
        public void add(String s) {
            Node temp = root;
            
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(temp.links[ch - 'a'] == null) {
                    temp.links[ch - 'a'] = new Node();
                } 
                temp.links[ch-'a'].count++;
                temp = temp.links[ch - 'a'];
            }
        }
        
        public int getScore(String s) {
            int score = 0;
            Node temp = root;
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                
                score += temp.links[ch-'a'].count;
                temp = temp.links[ch-'a'];
            }
            
            return score;
        }
    }
    
    class Node {
        int count = 0;
        Node[] links = new Node[26];
    }
    
    public int[] sumPrefixScores(String[] words) {
        // add each of the words in trie
        Trie trie = new Trie();
        for(String word: words) {
            trie.add(word);
        }
        
        int n = words.length;
        int[] scores = new int[n];
        
        // get the counts for each prefix
        for(int i=0; i<n; i++) {
            scores[i] = trie.getScore(words[i]);    
        }
        
        
        return scores;
    }
}