class Solution {
    // Map<String, Integer> memo = new HashMap<>();
    
    public int getNumberOfRolls(int n, int k, int target, int[][] memo){
        int ans = 0;
        
        // desired state, this is one of the possible ways
        if(n == 0 && target == 0)
            return 1;
        
        // dice are over but target is not met
        // or we still have dice and target becomes invalid
        // not a valid way, reject it
        if(n <= 0 || target <= 0)
            return 0;
        
        
        if(memo[n][target] != -1)
            return memo[n][target];
        
        
        for(int i=0; i<k; i++) {
            ans = (ans + getNumberOfRolls(n-1, k, target-(i+1), memo)) % 1000000007; 
        }
        
        // memo.put(key, ans);
        memo[n][target] = ans;
        return ans;
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] memo = new int[n+1][target+1];
        
        for(int i = 0; i <= n; i++){
            Arrays.fill(memo[i], -1);
        }
        
        return getNumberOfRolls(n, k, target, memo);
        
        // return 0;
    }
    
    
}