class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // dfs
        dfs(rooms, 0);
        
        if(visited.size() == rooms.size())
            return true;
        return false;
    }
    
    public void dfs(List<List<Integer>> rooms, int curr) {
        visited.add(curr);

        for(int room: rooms.get(curr)) {
            if(!visited.contains(room))
                dfs(rooms, room);
        }        
    }
}