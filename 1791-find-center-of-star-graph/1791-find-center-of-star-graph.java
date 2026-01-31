class Solution {
    public int findCenter(int[][] edges) {
        // no need to check the entire graph
        // checking 1st 2 edges is sufficient

        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }
}