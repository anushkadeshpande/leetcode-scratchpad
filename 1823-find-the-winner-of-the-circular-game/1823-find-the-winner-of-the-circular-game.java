class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            friends.add(i+1);
        int pos = 0;
        while(friends.size() != 1) {
            
            pos = (pos + k - 1) % friends.size();
            friends.remove(pos);
            
        }
        
        return friends.get(0);
    }
}