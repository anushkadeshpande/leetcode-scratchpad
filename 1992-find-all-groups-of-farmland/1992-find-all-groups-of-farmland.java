class Solution {
    // int[][] answer = new int[10][4];
    ArrayList<int[]> answer = new ArrayList<>();
    
    public int[][] findFarmland(int[][] land) {
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j] == 1) {
                    int[] coordinates = {i, j, 0, 0};
                    dfs(land, i, j, coordinates);
                    answer.add(coordinates);
                }
            }
        }
        
        return answer.toArray(new int[answer.size()][4]);
    }
    
    private void dfs(int[][] land, int i, int j, int[] coordinates) {
        if(i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0 || land[i][j] == -1)
            return;
        
        // visit current cell
        land[i][j] = -1;
        
        // note current coordinates
        coordinates[2] = Math.max(i, coordinates[2]);
        coordinates[3] = Math.max(j, coordinates[3]);
        
        dfs(land, i+1, j, coordinates);
        dfs(land, i-1, j, coordinates);
        dfs(land, i, j+1, coordinates);
        dfs(land, i, j-1, coordinates);
    }
}