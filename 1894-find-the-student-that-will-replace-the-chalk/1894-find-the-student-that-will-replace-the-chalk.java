class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int idx = 0;
        int n = chalk.length;
        
        int totalChalk = 0;
        for(int i=0; i<chalk.length; i++) {
            totalChalk += chalk[i];
            
            if (totalChalk > k) return i;
        }
        
        k = k % totalChalk;
        
        while(k >= chalk[idx]) {
            k -= chalk[idx];
            
            idx = (idx + 1) % n;
        }
        
        return idx;
    }
}