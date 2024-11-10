class Solution {
    int[][] memo;
    public int maxSatisfaction(int[] satisfaction) {
        // for every dish either take or dont take
        
        // sort the array in ascending order
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        
        memo = new int[n+1][n+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                memo[i][j] = -1;
            }
        }
        return getMaxSatisfaction(satisfaction, 0, 1);
    }
    
    public int getMaxSatisfaction(int[] satisfaction, int dish, int time) {
        if(dish == satisfaction.length)
            return 0;
        
        if(memo[dish][time] != -1)
            return memo[dish][time];
        
        int currentSatisfaction = time * satisfaction[dish];
        
        memo[dish][time] = Math.max(currentSatisfaction+ getMaxSatisfaction(satisfaction, dish+1, time+1), getMaxSatisfaction(satisfaction, dish+1, time));
        
        return memo[dish][time];
    }
}