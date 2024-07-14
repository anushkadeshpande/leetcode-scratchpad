class Solution {
    
    public void traverse(Map<Integer, List<Integer>> adjacencyList, int source, List<Integer> sol, Set<Integer> visited) {
        if(!visited.contains(source)) {
            sol.add(source);
            visited.add(source);
            for(int node: adjacencyList.get(source))
                traverse(adjacencyList, node, sol, visited);
        }
    }
    
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for(int i=0; i<adjacentPairs.length; i++) {
            if(!adjacencyList.containsKey(adjacentPairs[i][0])) {
                adjacencyList.put(adjacentPairs[i][0], new ArrayList<>());
            }
            
            if(!adjacencyList.containsKey(adjacentPairs[i][1])) {
                adjacencyList.put(adjacentPairs[i][1], new ArrayList<>());
            }
            
            adjacencyList.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            adjacencyList.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        
        
        List<Integer> sol = new ArrayList<>();
        
        for(int source: adjacencyList.keySet()) {
            if(adjacencyList.get(source).size() == 1) {
                traverse(adjacencyList, source, sol, new HashSet<Integer>());
                
                break;
            }
        }
        
        int[] result = new int[sol.size()];
        int i = 0;
        for(int s:sol) {
            result[i++] = s;
        }
        return result;
    }
}