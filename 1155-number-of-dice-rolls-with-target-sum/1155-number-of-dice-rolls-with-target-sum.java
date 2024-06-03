class Solution {
    Map<String, Integer> memo = new HashMap<>();
    
    public int numRollsToTarget(int n, int k, int target) {
        int ans = 0;
        
        String key = n + "_" + target;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        // desired state, this is one of the possible ways
        if(n == 0 && target == 0)
            return 1;
        
        // dice are over but target is not met
        // or we still have dice and target becomes invalid
        // not a valid way, reject it
        if(target < 0 || n <= 0)
            return 0;
        
        for(int i=0; i<k; i++) {
            ans = (ans + numRollsToTarget(n-1, k, target-(i+1))) % 1000000007; 
        }
        
        memo.put(key, ans);
        
        return ans;
    }
}