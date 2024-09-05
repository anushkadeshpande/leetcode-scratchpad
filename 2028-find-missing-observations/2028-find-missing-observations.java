class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumOfRolls = 0;
        for(int roll: rolls)
            sumOfRolls += roll;

        int rhs = (mean * (n+rolls.length)) - sumOfRolls;
        
        // invalid case
        if(rhs > (6 * n) || rhs < n)
            return new int[]{};
        
        // valid case
        // we need to split rhs into n parts 
        int partValue = rhs/n;
        int partRemainder = rhs % n;
        
        int[] missingRolls = new int[n];
        
        for(int i=0; i<n; i++) {
            missingRolls[i] = partValue;
            if(partRemainder > 0) {
                missingRolls[i] ++;
                partRemainder--;
            }
        }
        
        return missingRolls;
    }
}