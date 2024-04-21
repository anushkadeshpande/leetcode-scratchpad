class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        
        // construct graph as adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // perform dfs
        
        dfs(graph, visited, 0);
        if(visited[source] && visited[destination])
            return true;
        return false;
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
        if(visited[node])
            return;
        
        visited[node] = true;
        
        if(graph.get(node) != null)
            for(Integer n: graph.get(node)) {
                dfs(graph, visited, n);
            }
    }
}