class Solution {
    
    class Node {
        Node links[] = new Node[2];
    }
    
    class Trie {
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
        
        public int getMax(int num) {
            Node temp = node;
            int maxNum = 0;
            for(int i=31; i>=0; i--) {
                int bit = (num >> i) & 1;
                
                if(temp.links[1-bit] != null) {
                    maxNum = maxNum | (1 << i);
                    temp = temp.links[1-bit];
                } else 
                    temp = temp.links[bit];
            }
            
            return maxNum;
        }
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        Trie trie = new Trie();
        
        // sort nums
        Arrays.sort(nums);
        
        // sort queries based on mi
        List<List<Integer>> sortedQueries = new ArrayList<>();
        
        int numQueries = queries.length;
        int numNums = nums.length;
        
        for(int i=0; i<numQueries; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(queries[i][0]);
            temp.add(queries[i][1]);
            temp.add(i);
            
            sortedQueries.add(temp);
        }
        
        sortedQueries.sort((a, b) -> a.get(1) - b.get(1));
        
        int numIdx = 0;
        int answer[] = new int[numQueries];
        
        for(int i=0; i<numQueries; i++) {
            while(numIdx < numNums && nums[numIdx] <= sortedQueries.get(i).get(1)) {
                // insert into trie
                trie.insert(nums[numIdx]);
                numIdx++;
                
            }
                // get max
            if(numIdx == 0) {
                answer[sortedQueries.get(i).get(2)] = -1;
            }
            else
                answer[sortedQueries.get(i).get(2)] = trie.getMax(sortedQueries.get(i).get(0));;
                // queryIdx++;
              
        }
        
        return answer;
    }
}