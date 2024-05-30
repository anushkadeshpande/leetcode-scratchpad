class Solution {
    public int findCenter(int[][] edges) {
            // prepare adjacency list
    Map<Integer, Integer> edgeCount = new HashMap<>();
    int edge = 0;
    for(int i=0; i<edges.length; i++) {
        int[] e = edges[i];
        if(edgeCount.containsKey(e[0])) {
            edge = edgeCount.get(e[0]);
            if(edge == (edgeCount.keySet().size() - 2))
                return e[0];
            edgeCount.put(e[0], edge + 1);
        } else {
            edgeCount.put(e[0], 1);
        }
        
        if(edgeCount.containsKey(e[1])) {
            edge = edgeCount.get(e[1]);
            if(edge == (edgeCount.keySet().size() - 2))
                return e[1];
            edgeCount.put(e[1], edge + 1);
        } else {
            edgeCount.put(e[1], 1);
        }
    }
    
    return -1;

    }
    
    
}