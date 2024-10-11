class Solution {
    class Node{
        Node[] links = new Node[26];
        boolean flag = false;
    }

    class Trie {
        Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void insert(String s) {
            Node temp = root;
            
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(temp.links[ch - 'a'] == null)
                    temp.links[ch - 'a'] = new Node();
                temp = temp.links[ch - 'a'];
            }
            temp.flag = true;
        }
    }
    
    int[] dp;
    
    public int dfs(int i, String s, Trie trie) {
        if(i == s.length())
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int res = -1;
        // skip current char
        res = 1 + dfs(i+1, s, trie);
        
        // take current char
        Node curr = trie.root;
        
        for(int j=i; j<s.length(); j++) {
            char ch = s.charAt(j);
            if(curr.links[ch - 'a'] == null)
                break;
            curr = curr.links[ch - 'a'];
            if(curr.flag)
                res = Math.min(res, dfs(j+1, s, trie));
        }
        
        dp[i] = res;
        return res;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
       Trie trie = new Trie();
        dp = new int[s.length()];
        for(int i=0; i<s.length(); i++)
            dp[i] = -1;
        
        // insert all of the words in the trie
        for(String word: dictionary)
            trie.insert(word);
        
        return dfs(0, s, trie);
    }
}