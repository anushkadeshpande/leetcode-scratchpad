class Solution {
    
    public class Node {
        Node links[] = new Node[2];
    }
    
    public class Trie {
        Node node;
        
        public Trie() {
            node = new Node();
        }
        
        public void insert(int num) {
            Node temp = node;
            
            for(int i=31; i>=0; i--) {
                int bit = (num >> i) & 1;
                
                if(temp.links[bit] == null) {
                    temp.links[bit] = new Node();
                }
                
                temp = temp.links[bit];
            }
        }
        
        public int getMaxXor(int num) {
            Node temp = node;
            
            int maxNum = 0;
            
            for(int i=31; i>=0; i--) {
                 int bit = (num >> i) & 1;
                if(temp.links[1-bit] != null) {
                    temp = temp.links[1-bit];
                    maxNum = maxNum | (1 << i);
                } else {
                    temp = temp.links[bit];
                }
            }
            
            return maxNum;
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        // put all numbers in trie
        // find max xor with each number in the trie
        Trie trie = new Trie();
            
        for(int i=0; i<nums.length; i++) {
            trie.insert(nums[i]);
        }
        
        int maxNum = 0;
        for(int i=0; i<nums.length; i++) {
            maxNum = Math.max(maxNum, trie.getMaxXor(nums[i]));
        }
        
        return maxNum;
    }
}