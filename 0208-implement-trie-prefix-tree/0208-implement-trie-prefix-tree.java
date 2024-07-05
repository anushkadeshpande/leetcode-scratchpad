class Trie {
    class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch) {
            this.links[ch - 'a'] = new Node();
        }

        public Node get(char ch) {
            return this.links[ch - 'a'];
        }

        public void setEnd() {
            this.flag = true;
        }

        public boolean isEnd() {
            return this.flag;
        }
    }
    
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = this.root;
        int i = 0;
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            // if the current char does not exist in trie, add it and create a new node at
            // that position
            if (!temp.containsKey(currentChar)) {
                // temp.links[word.charAt(i) - 'a'] = new Node();
                temp.put(currentChar);
            }

            // move to the reference trie
            temp = temp.get(currentChar);

            i++;
        }

        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node temp = this.root;
        int i = 0;

        while (i < word.length()) {
            char currentChar = word.charAt(i);
            if (!temp.containsKey(currentChar))
                return false;

            temp = temp.get(currentChar);
            i++;
        }

        return temp.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node temp = this.root;
        int i = 0;

        while (i < prefix.length()) {
            char currentChar = prefix.charAt(i);
            if (!temp.containsKey(currentChar))
                return false;

            temp = temp.get(currentChar);
            i++;
        }

        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */