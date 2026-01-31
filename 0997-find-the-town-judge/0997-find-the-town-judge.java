class Solution {
    public int findJudge(int n, int[][] trust) {
        // consider it as a graph
        // trust is an adjacency list
        // node with indegree n-1 and outdegree 0 is the judge
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int i=0; i<trust.length; i++) {
            indegree[trust[i][1]-1]++;
            outdegree[trust[i][0]-1]++;
        }

        for(int i=0; i<n; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0)
                return i+1;
        }

        return -1;
    }
}